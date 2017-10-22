package com.ypy.fetch;

/**
 * TUserfk entity. @author MyEclipse Persistence Tools
 */

public class TUserfk implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String username;
	private String sex;
	private Short age;
	private TUserconf conf;
	
	// Constructors

	/** default constructor */
	public TUserfk() {
	}

	/** full constructor */
	public TUserfk(String username, String sex, Short age) {
		this.username = username;
		this.sex = sex;
		this.age = age;

	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Short getAge() {
		return this.age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public TUserconf getConf() {
		return conf;
	}

	public void setConf(TUserconf conf) {
		this.conf = conf;
	}


}