package com.flower.vo;

public class FlowerProductVO {
	private String category, code, name, information, text1, text2;
	private int price;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	@Override
	public String toString() {
		return "FlowerProductVO [category=" + category + ", code=" + code + ", name=" + name + ", price=" + price
				+ ", information=" + information + ", text1=" + text1 + ", text2=" + text2 + "]";
	}
	
}
