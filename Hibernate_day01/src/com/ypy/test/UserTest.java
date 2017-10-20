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
		user.setUsername("hibernate测试");
		
		//1.读取配置文件
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//2.获取sessionFactory对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		
		//3.获取session对象
		Session session = factory.openSession();
		//4.获取事务管理器
		Transaction transaction = session.beginTransaction();
		try {
			session.save(user);
			transaction.commit();   //进行事务提交
		} catch (Exception e) {
			transaction.rollback();   //出错后事务回滚
		}
		session.close();
	}
	
	@Test
	public void testUpdate() {
		TUsers user = new TUsers();
		user.setUserid(BigDecimal.valueOf(162));
		user.setUsername("hibernate测试");
		user.setPassword("123");
		
		//1.读取配置文件
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//2.获取sessionFactory对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		
		//3.获取session对象
		Session session = factory.openSession();
		//4.获取事务管理器
		Transaction transaction = session.beginTransaction();
		try {
			session.update(user);
			transaction.commit();   //进行事务提交
		} catch (Exception e) {
			transaction.rollback();   //出错后事务回滚
		}
		session.close();
	}
	
	@Test
	public void testDelete() {
		TUsers user = new TUsers();
		user.setUserid(BigDecimal.valueOf(162));
		
		//1.读取配置文件
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//2.获取sessionFactory对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		
		//3.获取session对象
		Session session = factory.openSession();
		//4.获取事务管理器
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(user);
			transaction.commit();   //进行事务提交
		} catch (Exception e) {
			transaction.rollback();   //出错后事务回滚
		}
		session.close();
	}
	
	/**
	 * get与load方法的区别：
	 * 1.当无要查询的记录时，get会返回null，load会报错。
	 * 2.不管查询对象是否被使用，get方法都会执行查询语句，load方法是只有查询对象被使用时，才会调用sql语句。
	 *   即load方法会延迟加载。
	 */
	@Test
	public void get() {
		//获取session
		//可直接通过HibernateSessionFactory类来创建session
		Session session = HibernateSessionFactory.getSession();
		TUsers user = (TUsers)session.get(TUsers.class, BigDecimal.valueOf(2));
		System.out.println(user);
		HibernateSessionFactory.closeSession();
	}
	
	@Test
	public void load() {
		//获取session
		Session session = HibernateSessionFactory.getSession();
		TUsers user = (TUsers)session.load(TUsers.class, BigDecimal.valueOf(2));
		System.out.println(user);
		HibernateSessionFactory.closeSession();
	}

}
