package com.flower.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerProductDAO;
import com.flower.vo.FlowerProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FlowerAddProductImage implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		String path = request.getServletContext().getRealPath("image");
		String categoryPath = path + "\\product";
		String encType = "utf-8";
		int maxSize = 20 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, categoryPath, maxSize, encType,
				new DefaultFileRenamePolicy());

		String category = multi.getParameter("product");
		String imageName = multi.getFilesystemName("uploadFile");
		String image = "product\\" + imageName;
		String code = multi.getParameter("code");
		
		
		
		
		
		
		
		// 코드값으로 이미지폼 다시 열기
		
		String url = "/flower/adminPage/flowerProductImageForm.jsp";

		
		request.setAttribute("code", code);

		FlowerProductDAO pdao = FlowerProductDAO.getInstance();
		pdao.insertProductImage(code, image);
		List<String> imageList = pdao.selectProductImage(code);
		
		request.setAttribute("imageList", imageList);

		FlowerProductVO pvo = pdao.selectProduct(code);
		String name = pvo.getName();
		request.setAttribute("name", name);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
