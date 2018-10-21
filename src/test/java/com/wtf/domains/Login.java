package com.wtf.domains;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Login {


  @SerializedName("sername")	
  public String username;
  
  @SerializedName("Name")
  public String Name;
  
  @SerializedName("password")
  public String password;

	private String getUsername() {
		return username;
	}	
	
	private void setUsername(String username) {
		this.username = username;
	}
	
	private String getName() {
		return Name;
	}
	
	private void setName(String name) {
		Name = name;
	}
	
	private String getPassword() {
		return password;
	}
	
	private void setPassword(String password) {
		this.password = password;
	}
   
}
