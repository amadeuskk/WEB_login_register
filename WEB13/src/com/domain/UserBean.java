package com.domain;

//此为JavaBean文件，设置和数据库相同类型的私有字段何其get,set方法，当然还有无参构造方法
public class UserBean {
	private String username;
	private String password;
	private String email;
	public UserBean() {
		
	}
	public String getusername() {
		return this.username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getpassword() {
		return this.password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getemail() {
		return this.email;
	}
	public void setemail(String email) {
		this.email = email;
	}
}
