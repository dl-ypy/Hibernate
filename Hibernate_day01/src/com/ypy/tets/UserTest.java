package com.ypy.tets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import com.ypy.pojo.TUsers;

public class UserTest {

	@Test
	public void test() {
		TUsers user = new TUsers();
		user.setUsername("hibernate����");
		
		//1.��ȡ�����ļ�
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//2.��ȡsessionFactory����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		
		//3.��ȡsession����
		Session session = factory.openSession();
		//4.��ȡ���������
		Transaction transaction = session.beginTransaction();
		try {
			session.save(user);
			transaction.commit();   //���������ύ
		} catch (Exception e) {
			transaction.rollback();   //���������ع�
		}
		session.close();
	}

}
