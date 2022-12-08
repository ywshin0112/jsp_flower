package com.flower.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerClientDAO;
import com.flower.vo.FlowerClientVO;

public class FlowerClientUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/flower/update.jsp";
		String id = request.getParameter("id");

	    FlowerClientDAO fdao = FlowerClientDAO.getInstance();
	    FlowerClientVO fvo = fdao.getFlowerClient(id);
	    request.setAttribute("fvo", fvo);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

		   
	}

}
