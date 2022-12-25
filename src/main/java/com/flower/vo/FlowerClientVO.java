package com.flower.vo;

public class FlowerClientVO {
	private String lev, id, pass, name, phone, email, address, detailed_address, refer;
	private int zip_code;
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailed_address() {
		return detailed_address;
	}
	public void setDetailed_address(String detailed_address) {
		this.detailed_address = detailed_address;
	}
	public String getRefer() {
		return refer;
	}
	public void setRefer(String refer) {
		this.refer = refer;
	}
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	@Override
	public String toString() {
		return "FlowerClientVO [lev=" + lev + ", id=" + id + ", pass=" + pass + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", detailed_address=" + detailed_address + ", refer="
				+ refer + ", zip_code=" + zip_code + "]";
	}
	
	
}
