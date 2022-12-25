package com.flower.controller.action;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerCategoryDAO;
import com.flower.dao.FlowerClientDAO;
import com.flower.unit.Pwd;
import com.flower.vo.FlowerCategoryVO;
import com.flower.vo.FlowerClientVO;

public class FlowerMembershipAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/flower/membership3.jsp";
		
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();

		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);
		
		String pass = request.getParameter("pass");
		Pwd pwd = Pwd.getInstance();
		try {
			pass = pwd.cryptPwd(pass);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FlowerClientVO fvo = new FlowerClientVO();
		fvo.setId(request.getParameter("id"));
		fvo.setPass(pass);
		fvo.setName(request.getParameter("name"));
		fvo.setPhone(request.getParameter("phone"));
		fvo.setEmail(request.getParameter("email"));
		fvo.setZip_code(Integer.parseInt(request.getParameter("zip_code")));
		fvo.setAddress(request.getParameter("address"));
		fvo.setDetailed_address(request.getParameter("detailed_address"));
		fvo.setRefer(request.getParameter("refer"));
		//fvo.setLev(request.getParameter("lev"));

		FlowerClientDAO fdao = FlowerClientDAO.getInstance();
		fdao.insertflowerClient(fvo);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
