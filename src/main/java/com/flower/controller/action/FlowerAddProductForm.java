package com.flower.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerCategoryDAO;
import com.flower.vo.FlowerCategoryVO;

public class FlowerAddProductForm implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/flower/adminPage/flowerAddProductForm.jsp";
		
		// 카테고리 리스트 불러오기
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();		 
		List<FlowerCategoryVO> categoryList = cdao.selectAllCategory();
		request.setAttribute("categoryList", categoryList);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}