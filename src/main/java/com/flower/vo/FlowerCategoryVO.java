package com.flower.vo;

public class FlowerCategoryVO {
	private String category, image;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "FlowerCategoryVO [category=" + category + ", image=" + image + "]";
	}
	
	
	
}
