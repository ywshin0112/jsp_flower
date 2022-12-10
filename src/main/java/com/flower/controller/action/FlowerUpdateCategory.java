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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FlowerUpdateCategory implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getServletContext().getRealPath("image");
		String categoryPath = path + "\\category";
		String encType = "utf-8";
		int maxSize = 20 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, categoryPath, maxSize, encType,
				new DefaultFileRenamePolicy());

		String category = multi.getParameter("category");
		String imageName = multi.getFilesystemName("uploadFile");
		String image = "category\\" + imageName;
		String beforeName = multi.getParameter("updateName");


		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();
		FlowerCategoryVO cvo = cdao.selectedCategory(beforeName);
		
		String beforeImage = cvo.getImage();

		
		cvo.setCategory(category);
		
		
		cvo.setImage(image);

		if (image.equals("category\\null")) {
			cdao.updateCategoryOnly(cvo, beforeName);
		} else {
 
			File file = new File(path + "\\" +beforeImage);
			System.out.println("파일명 : " + path + "\\" +beforeImage);
			if (file.exists()) { // 삭제하고자 하는 파일이 해당 서버에 존재하면 삭제시킨다
				file.delete();

			}
			cdao.updateImageAndCategory(cvo, beforeName);
		}

		

		String url = "/flower/adminPage/flowerCategoryList.jsp";

		List<FlowerCategoryVO> categoryList = cdao.selectAllCategory("where category not in (\'--추가상품--\')");
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}
}
