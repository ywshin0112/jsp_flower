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

public class FlowerInquiryForm implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/flower/buy/inquiry.jsp";
		String code = request.getParameter("code");
		// 헤더
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();

		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);

		// selectProduct
		FlowerProductDAO pdao = FlowerProductDAO.getInstance();

		FlowerProductVO productList = pdao.selectProduct(code);
		request.setAttribute("productList", productList);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
