package model;
import java.util.Date;
public class Account {
	Integer id;
	String userName;
	String email;
	String mobile;
	String sex;
	String pwd;
	Date creatTime;
	public Integer getId() { return id; }
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName()  { return userName; }
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return pwd;
	}
	public void setPassword(String pwd) {
		this.pwd = pwd;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

}
