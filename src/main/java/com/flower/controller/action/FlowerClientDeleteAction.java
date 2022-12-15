package com.flower.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
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

public class FlowerClientDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();

		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		FlowerClientDAO fdao = FlowerClientDAO.getInstance();
		FlowerClientVO fvo = fdao.getFlowerClient(id);
		if (fvo.getPass().equals(pass)) { // 성공
			fdao.deleteFlowerClient(id);
			HttpSession session = request.getSession();
			session.invalidate();
			response.setContentType("text/html; charset=euc-kr"); // 한글이 인코딩
			PrintWriter out = response.getWriter(); // 선언

			String str = "";
			str = "<script language='javascript'>";
			str += "opener.window.location.reload();"; // 오프너 새로고침
			str += "window.opener.parent.location.href = \"FlowerServlet?command=flower_main\";";
			str += "self.close();"; // 창닫기
			str += "alert(\"정상적으로 회원 탈퇴되었습니다.\");";
			str += "</script>";
			out.print(str);

		} else { // 실패
			url = "FlowerServlet?command=flowerClient_delete_form";
			request.setAttribute("massage", "비밀번호가 틀렸습니다.");
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
