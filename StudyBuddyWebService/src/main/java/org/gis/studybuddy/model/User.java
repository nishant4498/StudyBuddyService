package org.gis.studybuddy.model;

public class User {
	private String userid;
	private String name;
	private String password;

	public User() {
		super();
	}

	public User(String userId, String userName, String pass) {
		super();
		this.userid = userId;
		this.name = userName;
		this.password = pass;
	}

	public String getUserId() {
		return userid;
	}

	public void setUserId(String id) {
		this.userid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userid + ", name=" + name + ", password=" + password + "]";
	}
	

}
