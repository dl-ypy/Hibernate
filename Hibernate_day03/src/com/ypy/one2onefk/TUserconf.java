package com.ypy.one2onefk;

/**
 * TUserconf entity. @author MyEclipse Persistence Tools
 */

public class TUserconf implements java.io.Serializable {

	// Fields

	private Integer did;
	private String idecard;
	private String address;
	private String decx;
	
	private TUserfk user;
	

	// Constructors

	/** default constructor */
	public TUserconf() {
	}

	/** full constructor */
	public TUserconf(String idecard, String address, String decx) {
		this.idecard = idecard;
		this.address = address;
		this.decx = decx;
	}

	// Property accessors

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getIdecard() {
		return this.idecard;
	}

	public void setIdecard(String idecard) {
		this.idecard = idecard;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDecx() {
		return this.decx;
	}

	public void setDecx(String decx) {
		this.decx = decx;
	}

	public TUserfk getUser() {
		return user;
	}

	public void setUser(TUserfk user) {
		this.user = user;
	}

}