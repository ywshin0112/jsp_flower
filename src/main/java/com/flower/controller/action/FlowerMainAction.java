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
		
		
		// 1. [category, main image]
		// 2. [category, [image,name,price]]
		//  ㄴ 1+2 = [category, main image, [image,name,price]]
		
		for(int i=0; i<mainList.size(); i++) {
			
			// FlowerMainPageVO = {category, mainImage, dlvoList=[image,name,code,price]}
			FlowerMainPageVO mpvo = new FlowerMainPageVO();
			
			String category = mainList.get(i).getCategory();
			mpvo.setCategory(category);
			
			///////////////////////////////////////////
//			FlowerCategoryVO cvo = new FlowerCategoryVO();
			String mainImage = cdao.selectAllCategory("where category=\'"+ category +"\'").get(0).getImage();
			System.out.println(mainImage);
			mpvo.setMainImage(mainImage);
			
			//////////////////////////////////////////
			
			
			// product 테이블에서 카테고리, 코드, 네임, 가격 불러오기 (category 안에있는 모든 상품)
			FlowerProductDAO pdao = FlowerProductDAO.getInstance();
			List<FlowerProductVO> pvoList = pdao.selectOneCategory(category);
			
			
			
			// 이미지 리스트
			FlowerProductImageDAO fpidao = FlowerProductImageDAO.getInstance();
			ArrayList<FlowerProductImageVO> imageList = new ArrayList<FlowerProductImageVO>();
			
			for(int j=0; j<pvoList.size(); j++) {
				String code = pvoList.get(j).getCode();
				
				imageList = fpidao.selectMainImage(imageList, code);
				
			}
			
			ArrayList<FlowerDetailListVO> detailList = new ArrayList<FlowerDetailListVO>();
			for(int j=0; j<pvoList.size(); j++) {
				String code = pvoList.get(j).getCode();
				String name = pvoList.get(j).getName();
				int price = pvoList.get(j).getPrice();
				String image = imageList.get(j).getImage();
				
				FlowerDetailListVO dvo = new FlowerDetailListVO();
				
				dvo.setCode(code);
				dvo.setImage(image);
				dvo.setName(name);
				dvo.setPrice(price);
				
				detailList.add(dvo);		
			}
			
			mpvo.setDlvoList(detailList);
			
			
			mpvoList.add(mpvo);
			
		}
		
		
		
		request.setAttribute("mpvoList", mpvoList);
		
		
		
		

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
