package com.ibm.registration.userregistration.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRequest {
	
	@NotBlank
	private String userName;
	
	@NotBlank
	@Size(min=8, message = "password should have atleast 8 characters")
	private String password;
	
	
	@NotBlank
	private String ipAddress;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String toString() {
		return "UserRequest [userName=" + userName + ", password=" + password + ", ipAddress=" + ipAddress + "]";
	}
	
	
	

}
