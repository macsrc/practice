package com.gyan.basic.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gyan.basic.model.Formdata;

@Repository
public class FormdataDAOImpl implements FormdataDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(FormdataDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addFormdata(Formdata p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Formdata saved successfully, Formdata Details="+p);
	}

	@Override
	public void updateFormdata(Formdata p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Formdata updated successfully, Formdata Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Formdata> listFormdatas() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Formdata> formdatasList = session.createQuery("from Formdata").list();
		for(Formdata p : formdatasList){
			logger.info("Formdata List::"+p);
		}
		return formdatasList;
	}

	@Override
	public Formdata getFormdataById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Formdata p = (Formdata) session.load(Formdata.class, new Integer(id));
		logger.info("Formdata loaded successfully, Formdata details="+p);
		return p;
	}

	@Override
	public void removeFormdata(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Formdata p = (Formdata) session.load(Formdata.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Formdata deleted successfully, formdata details="+p);
	}

}
