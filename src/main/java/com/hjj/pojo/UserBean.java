package com.hjj.pojo;

public class UserBean {
	private String email;
	private String password;
	private String name;
	private String sex;
	private String iphone;
	private int roleid;
	private String oldpassword;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIphone() {
		return iphone;
	}
	public void setIphone(String iphone) {
		this.iphone = iphone;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	@Override
	public String toString() {
		return "Users [email=" + email + ", password=" + password + ", name=" + name + ", sex=" + sex + ", iphone="
				+ iphone + ", roleid=" + roleid + "]";
	}
	
}
