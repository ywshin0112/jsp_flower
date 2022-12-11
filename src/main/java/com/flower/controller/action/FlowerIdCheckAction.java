package com.flower.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerClientDAO;

public class FlowerIdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		FlowerClientDAO fdao = FlowerClientDAO.getInstance();
		int result = fdao.confrmID(id);
		String idLimit = "^(?=.*[A-Za-z])(?=.*[0-9])[a-z0-9]{3,12}$";
		if (!id.matches(idLimit)) {
			result = 2;
		}
		request.setAttribute("id", id);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("flower/idCheckForm.jsp");
		rd.forward(request, response);
	}

}
