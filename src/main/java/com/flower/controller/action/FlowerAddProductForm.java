package com.flower.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerCategoryDAO;
import com.flower.dao.FlowerProductDAO;
import com.flower.vo.FlowerCategoryVO;

public class FlowerAddProductForm implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/flower/adminPage/flowerAddProductForm.jsp";
		
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();

		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);
		
		// 카테고리 리스트 불러오기
		List<FlowerCategoryVO> categoryList = cdao.selectAllCategory("");
		request.setAttribute("categoryList", categoryList);

		// 모든 상품코드 가져오기

		FlowerProductDAO pdao = FlowerProductDAO.getInstance();
		List<String> codeList = pdao.selectProductCode("");
		request.setAttribute("codeList", codeList);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
