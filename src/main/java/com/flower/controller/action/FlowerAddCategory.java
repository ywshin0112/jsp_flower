package com.flower.controller.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerCategoryDAO;
import com.flower.vo.FlowerCategoryVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FlowerAddCategory implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getServletContext().getRealPath("image");
		String categoryPath = path + "/category";
		String encType = "utf-8";
		int maxSize = 20 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, categoryPath, maxSize, encType,
				new DefaultFileRenamePolicy());

		String category = multi.getParameter("category");
		String imageName = multi.getFilesystemName("uploadFile");
		String image = "category/" + imageName;
		String beforeName = multi.getParameter("updateName");

		System.out.println("category : " + category);
		System.out.println("path : " + path);
		System.out.println("image : " + image);
		System.out.println("beforeName : " + beforeName);

		FlowerCategoryVO cvo = new FlowerCategoryVO();

		cvo.setCategory(category);
		cvo.setImage(image);
		 
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();
		cdao.insertCategory(cvo);

		String url = "/flower/adminPage/flowerCategoryList.jsp";
		List<FlowerCategoryVO> categoryList = cdao.selectAllCategory();
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
