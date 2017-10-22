package com.ypy.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.ypy.fetch.TDepartment;
import com.ypy.fetch.TUserfk;
import com.ypy.utils.HibernateSessionFactory;

public class FetchTest {

	@Test
	public void fetchTest1() {
		Session session = HibernateSessionFactory.getSession();
		TUserfk user = (TUserfk) session.get(TUserfk.class, 21);
		System.out.println(user.getUsername());
		HibernateSessionFactory.closeSession();
	}
	/**
	 * fetch:
	 * 		1.join
	 * 		2.select:N+1����   һ��������Ϣ��Ӧһ���ӱ�sql���
	 * 		3.subselect: �����������ݶ�Ӧһ��sql���
	 * 		4.������:select+batch-size �������÷�������
	 */
	
	@Test
	public void fetchTest2() {
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "from TDepartment";
		Query query = session.createQuery(hql);
		List<TDepartment> list = query.list();
		for (TDepartment d : list) {
			System.out.println(d.getDname());
			System.out.println(d.getTEmployees().size());
		}
		
		HibernateSessionFactory.closeSession();
	}

}
