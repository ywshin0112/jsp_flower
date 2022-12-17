package com.flower.controller.action;

import java.io.IOException;
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

public class FlowerFindPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/flower/findPassSuccess.jsp";
		String id = request.getParameter("id");
		String email = request.getParameter("email");

		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();

		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);

		FlowerClientDAO fdao = FlowerClientDAO.getInstance();
		FlowerClientVO pass = fdao.FindPass(id, email);
		System.out.println(pass);
		if (pass == null) {
			url = "/flower/idPassCk.jsp";
		} else {
			String saveId = request.getParameter("saveId");

			url = "/flower/update.jsp";

			System.out.println("saveId : " + saveId);
			System.out.println("id : " + id);
			int result = fdao.userCheck(id, pass.getPass());

			// 로그인 성공
			System.out.println("로그인 성공");
			// 아이디 저장 여부를 보고 쿠키로 아이디값 저장
			Cookie c = new Cookie("saveId", id);
			// 쿠키값 저장 시간을 지정함, 숫자당 1초로 계산
			c.setMaxAge(60 * 60 * 24 * 7); // 7일간 저장
			response.addCookie(c);

			FlowerClientVO fvo = new FlowerClientVO();
			fvo = fdao.getFlowerClient(id);

			// 출력하는 부분
			HttpSession session = request.getSession();
			session.setAttribute("flowerClient", fvo); // 객체 담기
			session.setAttribute("result", result);

		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
