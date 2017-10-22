package com.ypy.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ypy.cache.TUser;
import com.ypy.utils.HibernateSessionFactory;

public class CacheTest {
	
	/**
	 * 统计功能代码，测试时使用
	 */
	SessionFactory factory = null;
	@Before
	public void setUp() throws Exception {
		factory = HibernateSessionFactory.getSessionFactory();
	}

	@After
	public void tearDown() throws Exception {
		Statistics s = factory.getStatistics();
		System.out.println("----------------------------------------");
		System.out.println("miss:" + s.getSecondLevelCacheMissCount());
		System.out.println("put:" + s.getSecondLevelCachePutCount());
		System.out.println("hit:" + s.getSecondLevelCacheHitCount());
	}
	
	@Test
	public void test() {
		Session session = HibernateSessionFactory.getSession();
		
		System.out.println("--------------从数据库取：--------------");
		TUser user1 = (TUser) session.get(TUser.class, 24);  //第一次从数据库中取
		System.out.println(user1.getUsername());
		
		System.out.println("-----------从一级缓存中取：------------");
		TUser user2 = (TUser) session.get(TUser.class, 24);  
		System.out.println(user2.getUsername());
		HibernateSessionFactory.closeSession();
		
		System.out.println("------------------一级缓存清空，从二级缓存中取：----------------");
		session = HibernateSessionFactory.getSession();
		
		TUser user3 = (TUser) session.get(TUser.class, 24);  //从二级缓存取
		System.out.println(user3.getUsername());
		
		HibernateSessionFactory.closeSession();
	}
	

}
