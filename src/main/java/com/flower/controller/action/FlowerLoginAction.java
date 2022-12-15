package com.flower.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flower.dao.FlowerCategoryDAO;
import com.flower.dao.FlowerClientDAO;
import com.flower.vo.FlowerCategoryVO;
import com.flower.vo.FlowerClientVO;

public class FlowerLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();

		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String saveId = request.getParameter("saveId");

		String url = null;

		FlowerClientDAO fdao = FlowerClientDAO.getInstance();
		int result = fdao.userCheck(id, pass);

		if (result == 1) { // 로그인 성공
			// 로그인 성공
			System.out.println("로그인 성공");
			// 아이디 저장 여부를 보고 쿠키로 아이디값 저장
			if (saveId != null) {
				Cookie c = new Cookie("saveId", id);
				// 쿠키값 저장 시간을 지정함, 숫자당 1초로 계산
				c.setMaxAge(60 * 60 * 24 * 7); // 7일간 저장
				response.addCookie(c);
			} else {
				Cookie c = new Cookie("saveId", id);
				c.setMaxAge(0);
				response.addCookie(c);
			}
			FlowerClientVO fvo = new FlowerClientVO();
			fvo = fdao.getFlowerClient(id);

//			출력하는 부분
			HttpSession session = request.getSession();
			session.setAttribute("flowerClient", fvo); // 객체 담기
			session.setAttribute("result", result);

			url = "flower/main.jsp";
		} else {
			url = "flower/login.jsp";
			if (result == 2) {
				request.setAttribute("message", "비밀번호를 확인해 주세요.");
			} else if (result == 0) {
				request.setAttribute("message", "존재하는 아이디가 없습니다.");
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
