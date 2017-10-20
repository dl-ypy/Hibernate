package com.ypy.test;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import com.ypy.pojo.TUsers;
import com.ypy.utils.HibernateSessionFactory;

public class UserTest {
	
	@Test
	public void testSave() {
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
	
	@Test
	public void testUpdate() {
		TUsers user = new TUsers();
		user.setUserid(BigDecimal.valueOf(162));
		user.setUsername("hibernate����");
		user.setPassword("123");
		
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
			session.update(user);
			transaction.commit();   //���������ύ
		} catch (Exception e) {
			transaction.rollback();   //���������ع�
		}
		session.close();
	}
	
	@Test
	public void testDelete() {
		TUsers user = new TUsers();
		user.setUserid(BigDecimal.valueOf(162));
		
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
			session.delete(user);
			transaction.commit();   //���������ύ
		} catch (Exception e) {
			transaction.rollback();   //���������ع�
		}
		session.close();
	}
	
	/**
	 * get��load����������
	 * 1.����Ҫ��ѯ�ļ�¼ʱ��get�᷵��null��load�ᱨ��
	 * 2.���ܲ�ѯ�����Ƿ�ʹ�ã�get��������ִ�в�ѯ��䣬load������ֻ�в�ѯ����ʹ��ʱ���Ż����sql��䡣
	 *   ��load�������ӳټ��ء�
	 */
	@Test
	public void get() {
		//��ȡsession
		//��ֱ��ͨ��HibernateSessionFactory��������session
		Session session = HibernateSessionFactory.getSession();
		TUsers user = (TUsers)session.get(TUsers.class, BigDecimal.valueOf(2));
		System.out.println(user);
		HibernateSessionFactory.closeSession();
	}
	
	@Test
	public void load() {
		//��ȡsession
		Session session = HibernateSessionFactory.getSession();
		TUsers user = (TUsers)session.load(TUsers.class, BigDecimal.valueOf(2));
		System.out.println(user);
		HibernateSessionFactory.closeSession();
	}

}
