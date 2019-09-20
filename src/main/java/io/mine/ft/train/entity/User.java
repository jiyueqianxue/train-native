package io.mine.ft.train.entity;

import java.util.List;

/**
 * 
 * 类的作用: 作者: 马超 创建时间: 2015-1-31下午1:55:15 email : zhangmj@zparkhr.com.cn version:
 * 1.0
 */
public class User {
	private Integer userId;
	private String username;
	private String password;
	private String realname;
	private String department;
	private String role;
	private List<Course> courses;
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username
				+ ", password=" + password + ", realname=" + realname
				+ ", department=" + department + ", role=" + role + "]";
	}

	public User(Integer userId, String username, String password,
			String realname, String department, String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.department = department;
		this.role = role;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
