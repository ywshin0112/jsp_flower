package com.flower.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerCategoryDAO;
import com.flower.dao.FlowerProductDAO;
import com.flower.dao.FlowerProductImageDAO;
import com.flower.vo.FlowerCategoryVO;
import com.flower.vo.FlowerProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FlowerAddProduct implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();

		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);
		
		FlowerProductVO pvo = new FlowerProductVO();
		
		String code = request.getParameter("code");
		
		pvo.setCategory(request.getParameter("category"));
		pvo.setCode(code);
		pvo.setInformation(request.getParameter("information"));
		pvo.setName(request.getParameter("name"));
		pvo.setPrice(Integer.parseInt(request.getParameter("price")));
		pvo.setText1(request.getParameter("text1"));
		pvo.setText2(request.getParameter("text2"));

		FlowerProductDAO pdao = FlowerProductDAO.getInstance();
		pdao.insertProduct(pvo);
		
		
		FlowerProductImageDAO pidao = FlowerProductImageDAO.getInstance();
		pidao.insertProductImage(code, "product\\wheelwind.gif");
		
		pidao.updateProductMainImage(code);
		
		

		String url = "/flower/adminPage/flowerProductList.jsp";

		List<FlowerProductVO> productList = pdao.selectAllCategory();
		request.setAttribute("productList", productList);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
