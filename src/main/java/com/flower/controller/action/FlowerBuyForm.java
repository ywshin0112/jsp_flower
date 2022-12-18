package com.flower.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

public class FlowerBuyForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/flower/buy/flowerBuyPage.jsp";
		String code = request.getParameter("code");

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
		
		//System.out.println(imageList);
		
		
		// selectOption
		ArrayList<FlowerCategoryOptionVO> coList = pdao.selectOptionCategory();
		request.setAttribute("coList", coList);
		
		// review
		FlowerReviewDAO frdao = FlowerReviewDAO.getInstance();
		ArrayList<FlowerReviewVO> reviewList = frdao.selectReview(code);
		request.setAttribute("reviewList", reviewList);
		
		// score
		double sum = 0.0, avg=0.0, scoreAvg=0.0;
		for(int i=0; i<reviewList.size(); i++) {
			sum = sum + reviewList.get(i).getScore(); 
		}
		avg = sum/reviewList.size();
		
		scoreAvg = Math.floor(avg*100)/100;
		if (Double.isNaN(scoreAvg)) {
			scoreAvg=0.0;
		}
		
		//System.out.println(scoreAvg);
		request.setAttribute("scoreAvg", scoreAvg);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
