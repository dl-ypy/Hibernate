package com.ypy.pojo;

import java.math.BigDecimal;


/**
 * TUsers entity. @author MyEclipse Persistence Tools
 */

public class TUsers  implements java.io.Serializable {


    // Fields    

     @Override
	public String toString() {
		return "TUsers [userid=" + userid + ", username=" + username + ", password=" + password + ", realname="
				+ realname + ", addr=" + addr + ", deptid=" + deptid + "]";
	}


	private BigDecimal userid;
     private String username;
     private String password;
     private String realname;
     private String addr;
     private BigDecimal deptid;


    // Constructors

    /** default constructor */
    public TUsers() {
    }

    
    /** full constructor */
    public TUsers(String username, String password, String realname, BigDecimal deptid) {
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.deptid = deptid;
    }

   
    // Property accessors

    public BigDecimal getUserid() {
        return this.userid;
    }
    
    public void setUserid(BigDecimal userid) {
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

    public String getRealname() {
        return this.realname;
    }
    
    public void setRealname(String realname) {
        this.realname = realname;
    }

    public BigDecimal getDeptid() {
        return this.deptid;
    }
    
    public void setDeptid(BigDecimal deptid) {
        this.deptid = deptid;
    }


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}
   








}