package com.flower.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerClientDAO;
import com.flower.vo.FlowerClientVO;

public class FlowerFindPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/flower/findPassSuccess.jsp";
		String id = request.getParameter("id");
		String email = request.getParameter("email");
	
		FlowerClientDAO fdao = FlowerClientDAO.getInstance();
		FlowerClientVO pass = fdao.FindPass(id, email);
		System.out.println(pass);
		request.setAttribute("flowerClient", pass);
		if (pass==null) {
			url = "/flower/idPassCk.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
