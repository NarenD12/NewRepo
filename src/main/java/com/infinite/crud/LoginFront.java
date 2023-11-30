package com.infinite.crud;

public class LoginFront {
	private String emailId;
	private String lastName;

	public LoginFront() {
	}

	public LoginFront(String emailId, String lastName) {
		super();
		this.emailId = emailId;
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
