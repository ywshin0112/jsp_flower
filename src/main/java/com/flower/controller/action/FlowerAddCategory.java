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
//		if(pictureUrl == null) {
//			pictureUrl = multi.getParameter("nonmakeImg");
//		}
		System.out.println("category : " + category);
		System.out.println("path : " + path);
		System.out.println("image : " + image);
		System.out.println("beforeName : " + beforeName);

		FlowerCategoryDAO fdao = FlowerCategoryDAO.getInstance();
		FlowerCategoryVO cvo = fdao.selectAllCategory(beforeName).get(1);

		cvo.setCategory(category);

		if (image.equals("category/null")) {

		} else {

			File file = new File(path + cvo.getImage());

			if (file.exists()) { // 삭제하고자 하는 파일이 해당 서버에 존재하면 삭제시킨다
				file.delete();

				cvo.setImage(image);
			}

			if (beforeName == null || beforeName.equals("")) { // 추가
				System.out.println("추가");
				fdao.insertCategory(cvo);
			} else { // 수정
				System.out.println("수정");
				fdao.updateCategory(cvo, beforeName);
			}

			String url = "/flower/adminPage/flowerCategoryList.jsp";
			FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();

			List<FlowerCategoryVO> categoryList = cdao.selectAllCategory("where category not in ('//옵션//')");
			request.setAttribute("categoryList", categoryList);
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}

	}
}