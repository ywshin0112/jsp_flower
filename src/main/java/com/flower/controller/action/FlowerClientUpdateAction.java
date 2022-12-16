package com.flower.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flower.dao.FlowerCategoryDAO;
import com.flower.dao.FlowerClientDAO;
import com.flower.vo.FlowerCategoryVO;
import com.flower.vo.FlowerClientVO;

public class FlowerClientUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/flower/mypage.jsp";
		String id = request.getParameter("id");
		
		// 헤더
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();

		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);
		
		// 회원 정보 수정
		FlowerClientVO fcvo = new FlowerClientVO();
		
		fcvo.setId(request.getParameter("id"));
		fcvo.setLev(request.getParameter("lev"));
		fcvo.setPass(request.getParameter("pass"));
		fcvo.setName(request.getParameter("name"));
		fcvo.setPhone(request.getParameter("phone"));
		fcvo.setEmail(request.getParameter("email"));
		fcvo.setEmail(request.getParameter("email"));
		fcvo.setAddress(request.getParameter("address"));
		
		FlowerClientDAO fcdao = FlowerClientDAO.getInstance();
		fcdao.updateFlowerClient(fcvo);
		
		// 세션에 수정된 회원정보를 담음
		HttpSession session = request.getSession();
		session.setAttribute("flowerClient", fcvo);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
