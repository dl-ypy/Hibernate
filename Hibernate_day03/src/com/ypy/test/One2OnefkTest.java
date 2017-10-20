package com.ypy.test;

import org.hibernate.Session;
import org.junit.Test;

import com.ypy.one2onefk.TUserfk;
import com.ypy.utils.HibernateSessionFactory;

public class One2OnefkTest {

	@Test
	public void test() {
		Session session = HibernateSessionFactory.getSession();
		TUserfk user = (TUserfk)session.get(TUserfk.class, 1);
		System.out.println(user.getUsername());
		System.out.println(user.getConf().getAddress());
		HibernateSessionFactory.closeSession();
	}

}
