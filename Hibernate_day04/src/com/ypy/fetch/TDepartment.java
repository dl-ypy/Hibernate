package com.ypy.fetch;

import java.util.HashSet;
import java.util.Set;

/**
 * TDepartment entity. @author MyEclipse Persistence Tools
 */

public class TDepartment implements java.io.Serializable {

	// Fields

	private Integer did;
	private String dname;
	private String ddecx;
	private Set TEmployees = new HashSet(0);

	// Constructors

	/** default constructor */
	public TDepartment() {
	}

	/** full constructor */
	public TDepartment(String dname, String ddecx, Set TEmployees) {
		this.dname = dname;
		this.ddecx = ddecx;
		this.TEmployees = TEmployees;
	}

	// Property accessors

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDdecx() {
		return this.ddecx;
	}

	public void setDdecx(String ddecx) {
		this.ddecx = ddecx;
	}

	public Set getTEmployees() {
		return this.TEmployees;
	}

	public void setTEmployees(Set TEmployees) {
		this.TEmployees = TEmployees;
	}

}