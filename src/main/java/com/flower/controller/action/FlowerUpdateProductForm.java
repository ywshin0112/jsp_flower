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
import com.flower.vo.FlowerCategoryVO;
import com.flower.vo.FlowerProductVO;

public class FlowerUpdateProductForm implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/flower/adminPage/flowerUpdateProductForm.jsp";
		
		String code = request.getParameter("code");
		
		// 카테고리 리스트 불러오기
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();		 
		List<FlowerCategoryVO> categoryList = cdao.selectAllCategory("");
		request.setAttribute("categoryList", categoryList);
		
		// 상품코드로 정보 불러오기
		FlowerProductDAO pdao = FlowerProductDAO.getInstance(); 
		FlowerProductVO pvo = pdao.selectProduct(code);
		request.setAttribute("pvo", pvo);
		
		// 모든 상품코드 가져오기
		
		List<String> codeList = pdao.selectProductCode(code);
		request.setAttribute("codeList", codeList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
