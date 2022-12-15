package com.flower.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerCategoryDAO;
import com.flower.dao.FlowerClientDAO;
import com.flower.vo.FlowerCategoryVO;
import com.flower.vo.FlowerClientVO;

public class FlowerFindIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/flower/findIdSuccess.jsp";
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();

		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);
		
		FlowerClientDAO fdao = FlowerClientDAO.getInstance();
		FlowerClientVO id = fdao.FindId(name, phone);

		request.setAttribute("flowerClient", id);
		System.out.println(id);
		if (id == null) {
			url = "/flower/idPassCk.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
