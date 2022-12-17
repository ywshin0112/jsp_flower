package com.flower.vo;

import java.sql.Date;

public class FlowerReviewVO {
	private int num, score;
	private String id, code, contents, image;
	private Date writedate;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	@Override
	public String toString() {
		return "FlowerReviewVO [num=" + num + ", score=" + score + ", id=" + id + ", code="
				+ code + ", contents=" + contents + ", image=" + image + ", writedate=" + writedate + "]";
	}
	
}
