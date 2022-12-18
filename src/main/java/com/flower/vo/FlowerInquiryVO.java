package com.flower.vo;

import java.sql.Date;

public class FlowerInquiryVO {
	private int num, count;
	private String code, title, id, contents, secret;
	private Date writedate;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	@Override
	public String toString() {
		return "FlowerInquiryVO [num=" + num + ", count=" + count + ", code=" + code + ", title=" + title + ", id=" + id
				+ ", contents=" + contents + ", secret=" + secret + ", writedate=" + writedate + "]";
	}
	
	
}
