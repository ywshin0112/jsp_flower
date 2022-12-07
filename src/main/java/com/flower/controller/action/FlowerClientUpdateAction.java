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
		String url = "flower/mypage.jsp";

		FlowerClientVO fvo = new FlowerClientVO();
		
		fvo.setId(request.getParameter("id"));
		fvo.setPass(request.getParameter("pass"));
		fvo.setName(request.getParameter("name"));
		fvo.setPhone(request.getParameter("phone"));
		fvo.setEmail(request.getParameter("emaill"));
		fvo.setAddress(request.getParameter("address"));
		fvo.setLev(request.getParameter("lev"));
		
		
		FlowerClientDAO fdao = FlowerClientDAO.getInstance();
		fdao.updateFlowerClient(fvo);
		
		List<FlowerClientVO> boardList = fdao.SelectAllFlowerClient();
		
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
