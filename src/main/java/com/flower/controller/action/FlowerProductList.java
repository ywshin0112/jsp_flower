package com.flower.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerCategoryDAO;
import com.flower.dao.FlowerProductDAO;
import com.flower.vo.FlowerCategoryVO;
import com.flower.vo.FlowerProductVO;

public class FlowerProductList implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/flower/adminPage/flowerProductList.jsp";

		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();

		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);

		FlowerProductDAO pdao = FlowerProductDAO.getInstance();

		List<FlowerProductVO> productList = pdao.selectAllCategory();
		request.setAttribute("productList", productList);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
