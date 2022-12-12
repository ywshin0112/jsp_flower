package com.flower.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerClientDAO;


public class FlowerMembershipFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/flower/membership2.jsp";
		FlowerClientDAO fdao = FlowerClientDAO.getInstance();
		
		List<String> clientPhoneList = fdao.selectPhone();
		List<String> clientEmailList = fdao.selectEmail();
		request.setAttribute("phoneList", clientPhoneList);
		request.setAttribute("emailList", clientEmailList);
		System.out.println(clientPhoneList);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
