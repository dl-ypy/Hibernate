package com.ypy.one2many;

/**
 * TEmployee entity. @author MyEclipse Persistence Tools
 */

public class TEmployee implements java.io.Serializable {

	// Fields

	private Integer eid;
	private TDepartment dept;
	private String ename;
	private String phone;

	// Constructors

	/** default constructor */
	public TEmployee() {
	}

	/** minimal constructor */
	public TEmployee(Integer eid) {
		this.eid = eid;
	}

	/** full constructor */
	public TEmployee(Integer eid, TDepartment TDepartment, String ename, String phone) {
		this.eid = eid;
		this.dept = TDepartment;
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

	public TDepartment getDept() {
		return this.dept;
	}

	public void setDept(TDepartment TDepartment) {
		this.dept = TDepartment;
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