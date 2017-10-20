package com.ypy.many2many;

import java.util.HashSet;
import java.util.Set;

/**
 * TMenu entity. @author MyEclipse Persistence Tools
 */

public class TMenu implements java.io.Serializable {

	// Fields

	private Integer mid;
	private String mname;
	private String mdecx;
	
	private Set<TRole> trole = new HashSet<TRole>();

	// Constructors

	/** default constructor */
	public TMenu() {
	}

	/** minimal constructor */
	public TMenu(Integer mid) {
		this.mid = mid;
	}

	/** full constructor */
	public TMenu(Integer mid, String mname, String mdecx) {
		this.mid = mid;
		this.mname = mname;
		this.mdecx = mdecx;
	}

	// Property accessors

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMdecx() {
		return this.mdecx;
	}

	public void setMdecx(String mdecx) {
		this.mdecx = mdecx;
	}

	public Set<TRole> getTrole() {
		return trole;
	}

	public void setTrole(Set<TRole> trole) {
		this.trole = trole;
	}

}