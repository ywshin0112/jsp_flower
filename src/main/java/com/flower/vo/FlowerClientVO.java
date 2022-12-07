package com.flower.vo;

public class FlowerClientVO {
	private String id, pass, name, phone, email, address, lev;

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

	public String getLev() {
		return lev;
	}

	public void setLev(String lev) {
		this.lev = lev;
	}

	@Override
	public String toString() {
		return "FlowerClientVO [id=" + id + ", pass=" + pass + ", name=" + name + ", phone=" + phone + ", email="
				+ email + ", address=" + address + ", lev=" + lev + "]";
	}
	
}
