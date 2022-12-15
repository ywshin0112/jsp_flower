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
import com.flower.vo.FlowerCategoryVO;
import com.flower.vo.FlowerProductImageVO;
import com.flower.vo.FlowerProductVO;

public class FlowerMainProductForm implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "flower/bouquet.jsp";
		
		String category = request.getParameter("category");
		
		
		System.out.println("카테고리 : "+category);
		
		// product 테이블에서 카테고리, 코드, 네임, 가격 불러오기
		FlowerProductDAO pdao = FlowerProductDAO.getInstance();
		List<FlowerProductVO> pvoList = pdao.selectOneCategory(category);
		request.setAttribute("pvoList", pvoList);	
		
		System.out.println("카테고리에서 가져온 값 : "+pvoList);
		
		// 헤더 메인 카테고리
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();
		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);		
		
		System.out.println("헤더 메인 카테고리에서 가져온 값 : "+mainList);
		
		// 카테고리 리스트
		//List<FlowerCategoryVO> categoryList = cdao.selectAllCategory();
		//request.setAttribute("mainList", mainList);		
		
//		String code = request.getParameter("code");
//		String main = request.getParameter("main");
		
		FlowerProductImageDAO fpidao = FlowerProductImageDAO.getInstance();
		ArrayList<FlowerProductImageVO> imageList = new ArrayList<FlowerProductImageVO>();
		
		for(int i=0; i<pvoList.size(); i++) {
			String code = pvoList.get(i).getCode();
			System.out.println("code : "+code);
			imageList = fpidao.selectMainImage(imageList, code);
			
		}
		

		
		
		System.out.println("imageList.size() : " + imageList.size());
//		FlowerProductImageDAO fpidao = FlowerProductImageDAO.getInstance();
//		List<FlowerProductImageVO> imageList = fpidao.selectMainImage(code);
		
		
		
		
		// 이미지테이블에서 코드값으로 가져오고 이미지 뿌리기

		request.setAttribute("imageList", imageList);	
		
		for(int i=0; i<imageList.size(); i++) {
			System.out.println("이미지 리스트 값 : "+imageList.get(i));
		}
//		System.out.println("이미지 리스트 값 : "+imageList);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		

	}

}
