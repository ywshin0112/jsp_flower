package com.flower.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerCategoryDAO;
import com.flower.vo.FlowerCategoryVO;

public class FlowerSelectCategory implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();

		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);
		
		String image[] = request.getParameterValues("categoryimage");
		String order[] = request.getParameterValues("order");

//		// 메인카테고리 리셋
//		cdao.resetMainCategory();

		// 선택항목만 메인카테고리로 변경

		for (int i = 0; i < image.length; i++) {
			cdao.updateMainCategory(image[i], order[i]);
		}

		// 카테고리 리스트로 이동
		String url = "/flower/adminPage/flowerCategoryList.jsp";

		List<FlowerCategoryVO> categoryList = cdao.selectAllCategory("where category not in (\'--추가상품--\')");
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
