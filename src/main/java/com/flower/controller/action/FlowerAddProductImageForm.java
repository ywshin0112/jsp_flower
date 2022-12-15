package com.flower.controller.action;

import java.io.IOException;
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

public class FlowerAddProductImageForm implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();

		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);

		String code = request.getParameter("code");

		String url = "/flower/adminPage/flowerProductImageForm.jsp";

		request.setAttribute("code", code);

		FlowerProductImageDAO idao = FlowerProductImageDAO.getInstance();
		List<FlowerProductImageVO> imageList = idao.selectProductImage(code);
		request.setAttribute("imageList", imageList);

		FlowerProductDAO pdao = FlowerProductDAO.getInstance();
		FlowerProductVO pvo = pdao.selectProduct(code);
		String name = pvo.getName();
		request.setAttribute("name", name);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
