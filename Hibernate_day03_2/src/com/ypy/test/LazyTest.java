package com.ypy.test;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Test;

import com.ypy.pojo.TDepartment;
import com.ypy.pojo.TUser;
import com.ypy.utils.HibernateSessionFactory;

public class LazyTest {
	/**
	 * �Զ���ʵ��Ĳ�ѯ
	 */
	@Test
	public void query1() {
		Session session = HibernateSessionFactory.getSession();
		TUser user = (TUser) session.load(TUser.class, 1);
//		System.out.println(user.getUsername());
		//���ӳټ���ʱ��ʹ������
//		Hibernate.initialize(user);  //ǿ�Ƽ��ع�������
		
		HibernateSessionFactory.closeSession();
//		System.out.println(user.getUsername());
	}
	
	/**
	 * �Լ������Ե��ӳټ���
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
