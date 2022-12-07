package com.flower.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerCategoryDAO;
import com.flower.vo.FlowerCategoryVO;

public class FlowerDeleteCategory implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category = request.getParameter("category");
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();
		cdao.deleteCategory(category);
		
		String url = "/flower/adminPage/flowerCategoryList.jsp";
		
		List<FlowerCategoryVO> categoryList = cdao.selectAllCategory("where category not in ('//옵션//')");
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
