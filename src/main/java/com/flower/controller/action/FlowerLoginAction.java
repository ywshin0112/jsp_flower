package com.flower.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flower.dao.FlowerClientDAO;
import com.flower.vo.FlowerClientVO;

public class FlowerLoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		
		String url = null;
		
		FlowerClientDAO fdao = FlowerClientDAO.getInstance();
		int result = fdao.userCheck(id, pass);
		
		if(result == 1) { // 로그인 성공
			FlowerClientVO fvo = new FlowerClientVO(); 
			fvo = fdao.getFlowerClient(id);
			
//			출력하는 부분
			HttpSession session = request.getSession();
			session.setAttribute("flowerClient", fvo); // 객체 담기
			session.setAttribute("result", result);
			
			url = "flower/main.jsp";
		}else{
			url ="flower/login.jsp";
			if(result == 0) {
				request.setAttribute("message", "아이디와 비밀번호를 다시 확인해 주세요");
			}else if(result == 2) {
				request.setAttribute("message", "비밀번호를 확인해 주세요.");
			}else if(result == 3) {
				request.setAttribute("message", "아이디를 확인해 주세요.");
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
