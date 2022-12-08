package com.flower.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flower.dao.FlowerClientDAO;
import com.flower.vo.FlowerClientVO;

public class FlowerClientDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		FlowerClientDAO fdao =FlowerClientDAO.getInstance();
		FlowerClientVO fvo = fdao.getFlowerClient(id);
		System.out.println(fvo);
		
		
		if(fvo.getPass().equals(pass)) { // 성공
			fdao.deleteFlowerClient(id);
			HttpSession session = request.getSession();
			session.invalidate();
			new FlowerMainAction().execute(request, response);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.');");
			out.println("return false;");
			out.println("</script>");
			url = "js/javascript:WinClose();";
		}else { // 실패
			url = "FlowerServlet?command=flowerClient_delete_form";
			request.setAttribute("massage", "비밀번호가 틀렸습니다.");
			request.setCharacterEncoding("utf-8");
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('비밀번호가 틀렸습니다.');");
//			out.println("return false;");
//			out.println("</script>");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
