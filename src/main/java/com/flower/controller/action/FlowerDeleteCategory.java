package com.flower.controller.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerCategoryDAO;
import com.flower.vo.FlowerCategoryVO;

public class FlowerDeleteCategory implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category = request.getParameter("category");

		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();
		FlowerCategoryVO cvo = cdao.selectedCategory(category);

		String image = cvo.getImage();

		String path = request.getServletContext().getRealPath("image");

		File file = new File(path + "/" + image);
		System.out.println("파일명 : " + path + "/" + image);
		if (file.exists()) { // 삭제하고자 하는 파일이 해당 서버에 존재하면 삭제시킨다
			file.delete();
		}
		cdao.deleteCategory(category);

		String url = "/flower/adminPage/flowerCategoryList.jsp";
 
		List<FlowerCategoryVO> categoryList = cdao.selectAllCategory("where category not in (\'--추가상품--\')");
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}
}
