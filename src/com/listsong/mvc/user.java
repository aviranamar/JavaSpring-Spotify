package com.listsong.mvc;

public class user {
	private String userName;
	private String lastName;
	private String password;
	public user() {
		super();
	}
	public user(String userName, String lastName, String password) {
		super();
		this.userName = userName;
		this.lastName = lastName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void copyme(tempuser obj) {
		
		this.userName = obj.getUserName();
		this.lastName = obj.getLastName();
		this.password = obj.getPassword();
	}
	@Override
	public String toString() {
		return "user [userName=" + userName + ", lastName=" + lastName + ", password=" + password + "]";
	}
}
