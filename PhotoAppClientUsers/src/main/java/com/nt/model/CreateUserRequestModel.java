package com.nt.model;

public class CreateUserRequestModel {
	
	/*@NotNull(message = "first name not be null")
	@Size(min=3,message="atleast 3 char required")*/
	private String firstName;
	
	/*@NotNull(message = "last name not be null")
	@Size(min=3,message="atleast 3 char required")*/
	private String lastName;

	/*@NotNull(message = "first name not be null")
	@Size(min=3,message="atleast 3 char required")
	@Email*/
	private String email;
	/*
	@NotNull(message = "first name not be null")
	@Size(min=3,max=16,message="atleast 3 char required")*/
	private String password;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
