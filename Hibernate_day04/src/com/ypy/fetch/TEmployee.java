package com.ypy.fetch;

/**
 * TEmployee entity. @author MyEclipse Persistence Tools
 */

public class TEmployee implements java.io.Serializable {

	// Fields

	private Integer eid;
	private TDepartment TDepartment;
	private String ename;
	private String phone;

	// Constructors

	/** default constructor */
	public TEmployee() {
	}

	/** full constructor */
	public TEmployee(TDepartment TDepartment, String ename, String phone) {
		this.TDepartment = TDepartment;
		this.ename = ename;
		this.phone = phone;
	}

	// Property accessors

	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public TDepartment getTDepartment() {
		return this.TDepartment;
	}

	public void setTDepartment(TDepartment TDepartment) {
		this.TDepartment = TDepartment;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}