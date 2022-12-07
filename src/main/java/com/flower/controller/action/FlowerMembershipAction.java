package com.flower.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerClientDAO;
import com.flower.vo.FlowerClientVO;

public class FlowerMembershipAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "flower/membership3.jsp";

		FlowerClientVO fvo = new FlowerClientVO();
		fvo.setId(request.getParameter("id"));
		fvo.setPass(request.getParameter("pass"));
		fvo.setName(request.getParameter("name"));
		fvo.setPhone(request.getParameter("phone"));
		fvo.setEmail(request.getParameter("email"));
		fvo.setAddress(request.getParameter("address"));
		fvo.setLev(request.getParameter("lev"));

		FlowerClientDAO fdao = FlowerClientDAO.getInstance();
		fdao.insertflowerClient(fvo);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
