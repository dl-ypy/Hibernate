package com.ypy.many2many;

import java.util.HashSet;
import java.util.Set;

/**
 * TRole entity. @author MyEclipse Persistence Tools
 */

public class TRole implements java.io.Serializable {

	// Fields

	private Integer rid;
	private String rname;
	private String rdecx;
	
	private Set<TMenu> tmenu = new HashSet<TMenu>();

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** minimal constructor */
	public TRole(Integer rid) {
		this.rid = rid;
	}

	/** full constructor */
	public TRole(Integer rid, String rname, String rdecx) {
		this.rid = rid;
		this.rname = rname;
		this.rdecx = rdecx;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRdecx() {
		return this.rdecx;
	}

	public void setRdecx(String rdecx) {
		this.rdecx = rdecx;
	}

	public Set<TMenu> getTmenu() {
		return tmenu;
	}

	public void setTmenu(Set<TMenu> tmenu) {
		this.tmenu = tmenu;
	}

}