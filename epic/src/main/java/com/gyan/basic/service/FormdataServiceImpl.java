package com.gyan.basic.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gyan.basic.dao.FormdataDAO;
import com.gyan.basic.model.Formdata;

@Service
public class FormdataServiceImpl implements FormdataService {
	
	private FormdataDAO formdataDAO;

	public void setFormdataDAO(FormdataDAO formdataDAO) {
		this.formdataDAO = formdataDAO;
	}

	@Override
	@Transactional
	public void addFormdata(Formdata p) {
		this.formdataDAO.addFormdata(p);
	}

	@Override
	@Transactional
	public void updateFormdata(Formdata p) {
		this.formdataDAO.updateFormdata(p);
	}

	@Override
	@Transactional
	public List<Formdata> listFormdatas() {
		return this.formdataDAO.listFormdatas();
	}

	@Override
	@Transactional
	public Formdata getFormdataById(int id) {
		return this.formdataDAO.getFormdataById(id);
	}

	@Override
	@Transactional
	public void removeFormdata(int id) {
		this.formdataDAO.removeFormdata(id);
	}

}
