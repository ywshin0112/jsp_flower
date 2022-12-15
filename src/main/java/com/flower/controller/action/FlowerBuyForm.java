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

public class FlowerBuyForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/flower/buy/flowerBuyPage.jsp";
		String code = request.getParameter("code");
		//System.out.println(code);
		
		// 메인 카테고리
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();

		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);
		
		//selectProduct
		FlowerProductDAO pdao = FlowerProductDAO.getInstance();

		FlowerProductVO productList = pdao.selectProduct(code);
		request.setAttribute("productList", productList);
		
		//selectImage
		FlowerProductImageDAO fpidao = FlowerProductImageDAO.getInstance();
		ArrayList<FlowerProductImageVO> imageList = fpidao.selectImage(code);
		
//		for(int i=0; i<imageList.size(); i++) {
////			String code = pvoList.get(i).getCode();
//			//System.out.println("code : "+code);
////			imageList = fpidao.selectImage(imageList, code);
//			System.out.println("이미지 리스트 값 : "+imageList);
//		}
		request.setAttribute("imageList", imageList);
		//System.out.println(imageList);
//		for(int i=0; i<imageList.size(); i++) {
//			
//		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
