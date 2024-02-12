package com.training.springwebdemo.model;

public class Users {

	private int uid;
	private String username;
	private String email;
	private String contact;
	private String addr;
	
	public Users(int uid, String username, String email, String contact, String addr) {
		super();
		this.uid = uid;
		this.username = username;
		this.email = email;
		this.contact = contact;
		this.addr = addr;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
		
	
}
