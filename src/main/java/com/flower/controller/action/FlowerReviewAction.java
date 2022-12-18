package com.flower.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerCategoryDAO;
import com.flower.dao.FlowerProductDAO;
import com.flower.dao.FlowerProductImageDAO;
import com.flower.dao.FlowerReviewDAO;
import com.flower.vo.FlowerCategoryOptionVO;
import com.flower.vo.FlowerCategoryVO;
import com.flower.vo.FlowerProductImageVO;
import com.flower.vo.FlowerProductVO;
import com.flower.vo.FlowerReviewVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FlowerReviewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String code = request.getParameter("code");

		// 이미지 업로드 관련 코드
		request.setCharacterEncoding("utf-8");
		ServletContext context = request.getSession().getServletContext();

		// 업로드 폴더 만들어줌
		String path = context.getRealPath("image");
		String encType = "UTF-8";
		int maxSize = 15 * 1024 * 1024;

		// request,파일저장경로,용량,인코딩타입,중복파일명에 대한 기본 정책
		MultipartRequest multi = new MultipartRequest(request, path, maxSize, encType, new DefaultFileRenamePolicy());

		// upload 폴더가 없는 경우 폴더를 만들어라
//		File dir = new File(reviewPath);
//		if (!dir.exists())
//			dir.mkdirs();

		int score = Integer.parseInt(multi.getParameter("score"));
		String id = multi.getParameter("id");
		String image = multi.getFilesystemName("image");
		// String image = "review\\" + imageName;
		String contents = multi.getParameter("contents");

		request.setAttribute("code", code);

		// review 정보 등록
		FlowerReviewVO rvo = new FlowerReviewVO();

		rvo.setScore(score);
		rvo.setId(id);
		rvo.setCode(code);
		rvo.setContents(contents);
		rvo.setImage(image);
		FlowerReviewDAO frdao = FlowerReviewDAO.getInstance();
		frdao.insertReview(rvo);

		// 메인 카테고리
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();

		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);

		// selectProduct
		FlowerProductDAO pdao = FlowerProductDAO.getInstance();

		FlowerProductVO productList = pdao.selectProduct(code);
		request.setAttribute("productList", productList);

		// selectImage
		FlowerProductImageDAO fpidao = FlowerProductImageDAO.getInstance();
		ArrayList<FlowerProductImageVO> imageList = fpidao.selectImage(code);

		request.setAttribute("imageList", imageList);

		// selectOption
		ArrayList<FlowerCategoryOptionVO> coList = pdao.selectOptionCategory();
		request.setAttribute("coList", coList);

		// review
		ArrayList<FlowerReviewVO> reviewList = frdao.selectReview(code);

		request.setAttribute("reviewList", reviewList);

		// score
		double sum = 0.0, avg = 0.0, scoreAvg = 0.0;
		for (int i = 0; i < reviewList.size(); i++) {
			sum = sum + reviewList.get(i).getScore();
		}
		avg = sum / reviewList.size();

		scoreAvg = Math.floor(avg * 100) / 100;
		if (Double.isNaN(scoreAvg)) {
			scoreAvg = 0.0;
		}
		
		request.setAttribute("scoreAvg", scoreAvg);

		String url = "/flower/buy/flowerBuyPage.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
