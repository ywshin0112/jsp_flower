package com.flower.vo;

import java.util.ArrayList;

public class FlowerMainPageVO {
	private String category;
	private ArrayList<FlowerDetailListVO> dlvoList;
	public String getCategory() {
		return category;
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
		return "FlowerMainPageVO [category=" + category + ", dlvoList=" + dlvoList + "]";
	}
}
