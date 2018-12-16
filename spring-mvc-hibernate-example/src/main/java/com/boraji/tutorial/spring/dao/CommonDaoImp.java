package com.boraji.tutorial.spring.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring.model.Cacdlg;

@Repository
public class CommonDaoImp implements CommonDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Cacdlg cacdlg) {
		sessionFactory.getCurrentSession().save(cacdlg);
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(int objId) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Cacdlg> listCacdlg() {
		@SuppressWarnings("unchecked")
		TypedQuery<Cacdlg> query = (TypedQuery<Cacdlg>) sessionFactory.getCurrentSession().createQuery("from Cacdlg");
		return (List<Cacdlg>) query.getResultList();
	}
	
//	public Map<String, String> getCacdlgMap() {
//		
////		Session em;
//		@SuppressWarnings("unchecked")
//		List<Object[]> list = ((Session) sessionFactory).createQuery("SELECT p.field1, p.field2 FROM Entity Cdlg").getResultList();
//		for (Object[] obj : list){
//		    System.out.println(obj[0]);
//		    System.out.println(obj[1]);
//		}
//	}
}
