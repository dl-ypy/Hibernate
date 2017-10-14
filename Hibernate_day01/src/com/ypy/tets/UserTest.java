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

}
