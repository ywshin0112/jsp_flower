package com.flower.unit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Pwd {
	private Pwd() {}
	
	private static Pwd instance = new Pwd();
	
	public static Pwd getInstance() {
		return instance;
	}
	
	
	
		
	public String encrypt(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(text.getBytes());

		return bytesToHex(md.digest());
	}

	private String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}
	
	public String cryptPwd (String password) throws NoSuchAlgorithmException  {
		
		String cryptogram = instance.encrypt(password);
		
		return cryptogram;
	}

	
}
