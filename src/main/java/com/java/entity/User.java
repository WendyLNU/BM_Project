package com.java.entity;

import org.springframework.data.annotation.Id;

public class User {

	/**
	 * cid:该字段用于mongodb的“_id”索引
	 * 用户实体
	 */
	@Id
	private String cid;
	
	private String username;
	
	private String password;
	
	public User() {
		
	}
	
	public User(String username,String password) {
		
		this.username=username;
		this.password=password;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
