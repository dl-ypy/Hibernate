package com.ypy.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.junit.Test;

import com.ypy.pojo.TUsers;
import com.ypy.utils.HibernateSessionFactory;

public class HQLTest {
	private String hql;
	private Session session;

	/**
	 * 查询多行一列,多行多列
	 */
	@Test
	public void test1() {
		Session session = HibernateSessionFactory.getSession();
		hql = "select username from TUsers";
		Query query = session.createQuery(hql);
		List<String> list = query.list();
		for (String string : list) {
			System.out.println(string);
		}
		hql = "select username,password from TUsers";
		query = session.createQuery(hql);
		List<Object[]> obj = query.list();
		for (Object[] objects : obj) {
			System.out.println(objects[0]+"-----"+objects[1]);
		}
		HibernateSessionFactory.closeSession();
	}
	
	/**
	 * 查询所有行
	 */
	@Test
	public void test2() {
		session = HibernateSessionFactory.getSession();
//		hql = "select t from TUsers t";
		hql = "from TUsers";   //简写
		Query createQuery = session.createQuery(hql);
		List<TUsers> list = createQuery.list();
		for (TUsers tUsers : list) {
			System.out.println(tUsers);
		}
		HibernateSessionFactory.closeSession();
	}
	
	/**
	 * 查询记录数
	 */
	@Test
	public void test3() {
		session = HibernateSessionFactory.getSession();
		hql = "select count(*) from TUsers";   //这里必须用*
		Query createQuery = session.createQuery(hql);
		long count = (long) createQuery.uniqueResult();
		System.out.println(count);
		HibernateSessionFactory.closeSession();
	}
	
	/**
	 * 带条件查询，占位符
	 */
	@Test
	public void test4() {
		session = HibernateSessionFactory.getSession();
		hql = "from TUsers where password like ?";
		Query createQuery = session.createQuery(hql);
		createQuery.setParameter(0, "1%");
		List<TUsers> list = createQuery.list();
		for (TUsers tUsers : list) {
			System.out.println(tUsers);
		}
		HibernateSessionFactory.closeSession();
	}
	
	/**
	 * 带条件查询，参数名
	 */
	@Test
	public void test5() {
		session = HibernateSessionFactory.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("password", "1%");
		map.put("username", "a%");
		hql = "from TUsers where password like :password and username like :username";
		Query createQuery = session.createQuery(hql);
		createQuery.setProperties(map);  //还可以放入TUsers对象中，通过对象设置
		List<TUsers> list = createQuery.list();
		for (TUsers tUsers : list) {
			System.out.println(tUsers);
		}
		HibernateSessionFactory.closeSession();
	}
	
	/**
	 * 分页查询
	 */
	@Test
	public void test6() {
		session = HibernateSessionFactory.getSession();
		hql = "from TUsers";   //简写
		Query createQuery = session.createQuery(hql);
		//设置分页的第一条记录下标
		createQuery.setFirstResult(3);
		//设置分页显示的条数
		createQuery.setMaxResults(2);
		List<TUsers> list = createQuery.list();
		for (TUsers tUsers : list) {
			System.out.println(tUsers);
		}
		HibernateSessionFactory.closeSession();
	}
	
	/**
	 * 修改
	 */
	@Test
	public void test7() {
		session = HibernateSessionFactory.getSession();
		hql = "update TUsers set username=? where userid=?"; 
		Query createQuery = session.createQuery(hql);
		createQuery.setParameter(0, "qqq");
		createQuery.setParameter(1, BigDecimal.valueOf(1));
		createQuery.executeUpdate();
		//添加事务
		Transaction transaction = null; 
		try {
			transaction = session.beginTransaction();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	
	/**
	 * 删除
	 */
	@Test
	public void test8() {
		session = HibernateSessionFactory.getSession();
		hql = "delete from TUsers where userid=?"; 
		Query createQuery = session.createQuery(hql);
		createQuery.setParameter(0, BigDecimal.valueOf(5));
		createQuery.executeUpdate();
		//添加事务
		Transaction transaction = null; 
		try {
			transaction = session.beginTransaction();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}
	
	/**
	 * 容器查询
	 */
	@Test
	public void test9() {
		session = HibernateSessionFactory.getSession();
		Criteria c = session.createCriteria(TUsers.class);
		c.add(Restrictions.like("password", "1%"));  //添加查询条件
		List<TUsers> list = c.list();
		for (TUsers tUsers : list) {
			System.out.println(tUsers);
		}
		HibernateSessionFactory.closeSession();
	}
	
	/**
	 * 原生本地sql
	 */
	@Test
	public void test10() {
		session = HibernateSessionFactory.getSession();
		String sql = "select * from t_users";   //简写
		SQLQuery createQuery = session.createSQLQuery(sql);
		List<Object[]> list = createQuery.list();
		for (Object[] obj: list) {
			System.out.println(obj[0]+"---------"+obj[1]);
		}
		HibernateSessionFactory.closeSession();
	}
	
	/**
	 * 原生本地sql查询记录数
	 */
	@Test
	public void test11() {
		session = HibernateSessionFactory.getSession();
		String sql = "select count(*) c from t_users";   //这里起个别名
		SQLQuery createQuery = session.createSQLQuery(sql);
		createQuery.addScalar("c", IntegerType.INSTANCE);   //表示允许用int接收
		Integer count = (Integer) createQuery.uniqueResult();
		System.out.println(count);
		HibernateSessionFactory.closeSession();
	}

}
