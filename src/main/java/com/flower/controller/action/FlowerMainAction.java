package com.flower.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.dao.FlowerCategoryDAO;
import com.flower.dao.FlowerProductDAO;
import com.flower.dao.FlowerProductImageDAO;
import com.flower.vo.FlowerCategoryVO;
import com.flower.vo.FlowerDetailListVO;
import com.flower.vo.FlowerMainPageVO;
import com.flower.vo.FlowerProductImageVO;
import com.flower.vo.FlowerProductVO;

public class FlowerMainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "flower/main.jsp";
		
		
		
		
		//공통 header
		FlowerCategoryDAO cdao = FlowerCategoryDAO.getInstance();
		
		List<FlowerCategoryVO> mainList = cdao.selectMainCategory();
		request.setAttribute("mainList", mainList);
		
		
		ArrayList<FlowerMainPageVO> mpvoList = new ArrayList<>();
		
		for(int i=0; i<mainList.size(); i++) {
			String category = mainList.get(i).getCategory();
			ArrayList<FlowerDetailListVO> dlvo = new ArrayList<>();
			
			
			
			
		}
		
		

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
