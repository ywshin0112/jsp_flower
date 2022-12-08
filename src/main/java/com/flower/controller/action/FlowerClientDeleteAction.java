package com.flower.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flower.dao.FlowerClientDAO;

public class FlowerClientDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/flower/main.jsp";
		String id = request.getParameter("id");
		FlowerClientDAO fdao =FlowerClientDAO.getInstance();
		fdao.deleteFlowerClient(id);
		HttpSession session = request.getSession();
		session.invalidate();
		new FlowerMainAction().execute(request, response);
	}
}
