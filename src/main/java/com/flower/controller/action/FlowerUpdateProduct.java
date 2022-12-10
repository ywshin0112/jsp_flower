package com.flower.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerProductDAO;
import com.flower.vo.FlowerProductVO;

public class FlowerUpdateProduct implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String constCode = request.getParameter("constCode");
		FlowerProductVO pvo = new FlowerProductVO();

		pvo.setCategory(request.getParameter("category"));
		pvo.setCode(request.getParameter("code"));
		pvo.setInformation(request.getParameter("information"));
		pvo.setName(request.getParameter("name"));
		pvo.setPrice(Integer.parseInt(request.getParameter("price")));
		pvo.setText1(request.getParameter("text1"));
		pvo.setText2(request.getParameter("text2"));

		FlowerProductDAO pdao = FlowerProductDAO.getInstance();
		pdao.updateProduct(pvo, constCode);

		String url = "/flower/adminPage/flowerProductList.jsp";


		List<FlowerProductVO> productList = pdao.selectAllCategory();
		request.setAttribute("productList", productList);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
		
	}

}
