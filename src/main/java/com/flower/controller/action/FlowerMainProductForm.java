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
import com.flower.vo.FlowerDetailListVO;
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
		request.setAttribute("category", category);	
		
		System.out.println("카테고리에서 가져온 값 : "+pvoList);
		
		// 헤더 메인 카테고리
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();
		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);		
		
		System.out.println("헤더 메인 카테고리에서 가져온 값 : "+mainList);
		
		// 카테고리 리스트

		
		FlowerProductImageDAO fpidao = FlowerProductImageDAO.getInstance();
		ArrayList<FlowerProductImageVO> imageList = new ArrayList<FlowerProductImageVO>();
		
		for(int i=0; i<pvoList.size(); i++) {
			String code = pvoList.get(i).getCode();
			System.out.println("code : "+code);
			imageList = fpidao.selectMainImage(imageList, code);
			
		}
		
		ArrayList<FlowerDetailListVO> detailList = new ArrayList<FlowerDetailListVO>();
		for(int i=0; i<pvoList.size(); i++) {
			String code = pvoList.get(i).getCode();
			String name = pvoList.get(i).getName();
			int price = pvoList.get(i).getPrice();
			String image = imageList.get(i).getImage();
			
			FlowerDetailListVO dvo = new FlowerDetailListVO();
			
			dvo.setCode(code);
			dvo.setImage(image);
			dvo.setName(name);
			dvo.setPrice(price);
			
			detailList.add(dvo);		
		}
		
		request.setAttribute("detailList", detailList);	

		
		// 이미지테이블에서 코드값으로 가져오고 이미지 뿌리기

		request.setAttribute("imageList", imageList);	
		
		for(int i=0; i<imageList.size(); i++) {
			System.out.println("이미지 리스트 값 : "+imageList.get(i));
		}

		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
