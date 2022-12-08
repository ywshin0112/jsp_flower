package com.flower.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerClientDAO;
import com.flower.vo.FlowerClientVO;

public class FlowerClientUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		
		FlowerClientVO fvo = new FlowerClientVO();

		fvo.setLev(request.getParameter("lev"));
		fvo.setName(request.getParameter("name"));
		fvo.setId(request.getParameter("id"));
		fvo.setPass(request.getParameter("pass"));
		fvo.setEmail(request.getParameter("email"));
		fvo.setPhone(request.getParameter("phone"));
		fvo.setAddress(request.getParameter("address"));	
		
		FlowerClientDAO fdao = FlowerClientDAO.getInstance();
		fdao.updateFlowerClient(fvo);
	    
	    new FlowerClientMypageAction().execute(request, response);
	}

}
