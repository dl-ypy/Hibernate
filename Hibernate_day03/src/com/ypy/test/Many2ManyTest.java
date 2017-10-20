package com.ypy.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.ypy.many2many.TMenu;
import com.ypy.many2many.TRole;
import com.ypy.utils.HibernateSessionFactory;

public class Many2ManyTest {

	@Test
	public void save() {
		
		TRole t1 = new TRole();
		t1.setRname("Ȩ�޹���");
		
		TMenu m1 = new TMenu();
		m1.setMname("��ͨ�û�");
		
		TMenu m2 = new TMenu();
		m2.setMname("������Ʒ");
		
		TMenu m3 = new TMenu();
		m3.setMname("��ɨ����");
		Set<TMenu> ms = new HashSet<TMenu>();
		ms.add(m1);
		ms.add(m2);
		ms.add(m3);
		
		t1.setTmenu(ms);
		
		HibernateSessionFactory.save(t1);
	}
	
	@Test
	public void delete(){
		TRole t1 = new TRole();
		t1.setRid(20);
		
		TMenu m1 = new TMenu();
		t1.setRid(20);
		
		Set<TRole> tr = new HashSet<TRole>();
		
		Set<TMenu> ms = new HashSet<TMenu>();
		ms.add(m1);
		
		t1.setTmenu(ms);
		m1.setTrole(tr);
		
		HibernateSessionFactory.delete(t1);
	}

}
