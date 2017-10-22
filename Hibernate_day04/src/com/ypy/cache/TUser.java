package com.ypy.cache;

import java.math.BigDecimal;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String username;
	private String password;
	private Short age;
	private BigDecimal did;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** full constructor */
	public TUser(String username, String password, Short age, BigDecimal did) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.did = did;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Short getAge() {
		return this.age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public BigDecimal getDid() {
		return this.did;
	}

	public void setDid(BigDecimal did) {
		this.did = did;
	}

}