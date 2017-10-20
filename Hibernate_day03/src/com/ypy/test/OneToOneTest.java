package com.ypy.test;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.ypy.pojo.TUser;
import com.ypy.pojo.TUserdetails;
import com.ypy.utils.HibernateSessionFactory;
/**
 * 一对一主键关联测试CRUD
 * @author ypy
 */
public class OneToOneTest {

	@Test
	public void testQuery() {
		Session session = HibernateSessionFactory.getSession();
		TUser user = (TUser)session.get(TUser.class, 1);
		System.out.println(user.getUsername());
		System.out.println(user.gettUserdetails().getAddress());
		HibernateSessionFactory.closeSession();
	}
	
	@Test
	public void testSave() {
		TUser user  = new TUser();
		user.setUsername("aaa");
		user.setAge((short)20);
		
		TUserdetails d = new TUserdetails();
		d.setAddress("ppppp");
		
		//相互设置
		user.settUserdetails(d);		
		d.settUser(user);

		HibernateSessionFactory.save(user);
	}
	
	
	@Test
	public void update() {
		TUser user  = new TUser();
		user.setUserid(2);
		user.setUsername("bbb");
		user.setAge((short)22);
		
		TUserdetails d = new TUserdetails();
		d.setUserid(2);
		d.setAddress("北京");
		
		//相互设置
		user.settUserdetails(d);
		d.settUser(user);
		HibernateSessionFactory.update(user);
	}
	
	@Test
	public void delete() {
		TUser user  = new TUser();
		user.setUserid(1);
		
		TUserdetails d = new TUserdetails();
		d.setUserid(1);
		
		//相互设置
		user.settUserdetails(d);
		d.settUser(user);
		HibernateSessionFactory.delete(user);
	}
}
