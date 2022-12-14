package com.flower.vo;

public class FlowerProductImageVO {
	private String code, image, main;
	private int num;

	public String getCode() {
		return code;
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "FlowerProductImageVO [code=" + code + ", image=" + image + ", main=" + main + ", num=" + num + "]";
	}
	
}
