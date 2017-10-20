package com.ypy.test;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Test;

import com.ypy.pojo.TDepartment;
import com.ypy.pojo.TUser;
import com.ypy.utils.HibernateSessionFactory;

public class LazyTest {
	/**
	 * 对对象实体的查询
	 */
	@Test
	public void query1() {
		Session session = HibernateSessionFactory.getSession();
		TUser user = (TUser) session.load(TUser.class, 1);
//		System.out.println(user.getUsername());
		//在延迟加载时，使用数据
//		Hibernate.initialize(user);  //强制加载关联对象
		
		HibernateSessionFactory.closeSession();
//		System.out.println(user.getUsername());
	}
	
	/**
	 * 对集合属性的延迟加载
	 */
	@Test
	public void query2() {
		Session session = HibernateSessionFactory.getSession();
		TDepartment d = (TDepartment) session.get(TDepartment.class, 20);
		System.out.println(d.getDname());
//		System.out.println(d.getTEmployees().size());
				
		HibernateSessionFactory.closeSession();
	
	}
}
