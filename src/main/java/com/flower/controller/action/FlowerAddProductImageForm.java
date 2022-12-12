package com.flower.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerProductDAO;
import com.flower.vo.FlowerProductVO;

public class FlowerAddProductImageForm implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/flower/adminPage/flowerProductImageForm.jsp";
		
		String code = request.getParameter("code");
		request.setAttribute("code", code);
		
		FlowerProductDAO pdao = FlowerProductDAO.getInstance();
		List<String> imageList = pdao.selectProductImage(code);
		request.setAttribute("imageList", imageList);
		
		FlowerProductVO pvo = pdao.selectProduct(code);
		String name = pvo.getName();
		request.setAttribute("name", name);
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
