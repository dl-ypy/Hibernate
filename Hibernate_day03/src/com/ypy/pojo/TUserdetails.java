package com.ypy.pojo;

/**
 * TUserdetails entity. @author MyEclipse Persistence Tools
 */

public class TUserdetails implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String address;
	
	private TUser tUser;

	// Constructors

	/** default constructor */
	public TUserdetails() {
	}

	/** minimal constructor */
	public TUserdetails(Integer userid) {
		this.userid = userid;
	}

	/** full constructor */
	public TUserdetails(Integer userid, String address) {
		this.userid = userid;
		this.address = address;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public TUser gettUser() {
		return tUser;
	}

	public void settUser(TUser tUser) {
		this.tUser = tUser;
	}

}