package com.ypy.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.ypy.one2many.TDepartment;
import com.ypy.one2many.TEmployee;
import com.ypy.utils.HibernateSessionFactory;

public class One2ManyTest {

	/**
	 * 查询主表
	 */
	@Test
	public void test() {
		Session session = HibernateSessionFactory.getSession();
		TDepartment dept = (TDepartment) session.get(TDepartment.class, 20);
		System.out.println(dept.getDname());
		System.out.println(dept.getEmps().size());
		HibernateSessionFactory.closeSession();
	}
	
	/**
	 * 查询从表
	 */
	@Test
	public void test2() {
		Session session = HibernateSessionFactory.getSession();
		TEmployee e = (TEmployee) session.get(TEmployee.class, 20);
		System.out.println(e.getEname());
		System.out.println(e.getDept().getDname());
		HibernateSessionFactory.closeSession();
	}
	
	/**
	 * 存储一条部门信息，同时可存储多条员工信息
	 */
	@Test
	public void save() {
		TDepartment dept = new TDepartment();
		dept.setDname("啊啊啊");
		
		TEmployee e1 = new TEmployee();
		e1.setEname("abc");
		e1.setDept(dept);
		
		TEmployee e2 = new TEmployee();
		e2.setEname("aaa");
		e2.setDept(dept);
		
		TEmployee e3 = new TEmployee();
		e3.setEname("ccc");
		e3.setDept(dept);
		
		Set<TEmployee>  emps = new HashSet<TEmployee>();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		
		dept.setEmps(emps);
		HibernateSessionFactory.save(dept);
	}

}
