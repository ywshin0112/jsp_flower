package com.flower.vo;

import java.util.ArrayList;

public class FlowerMainPageVO {
	private String category, mainImage;
	private ArrayList<FlowerDetailListVO> dlvoList;
	public String getCategory() {
		return category;
	}
	public String getMainImage() {
		return mainImage;
	}
	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public ArrayList<FlowerDetailListVO> getDlvoList() {
		return dlvoList;
	}
	public void setDlvoList(ArrayList<FlowerDetailListVO> dlvoList) {
		this.dlvoList = dlvoList;
	}
	@Override
	public String toString() {
		return "FlowerMainPageVO [category=" + category + ", mainImage=" + mainImage + ", dlvoList=" + dlvoList + "]";
	}
}
