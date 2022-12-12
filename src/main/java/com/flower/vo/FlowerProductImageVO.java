package com.flower.vo;

public class FlowerProductImageVO {
	private String code, image;

	public String getCode() {
		return code;
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
		return "FlowerProductImageVO [code=" + code + ", image=" + image + "]";
	}
	
}
