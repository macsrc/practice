package com.gyan.basic.dao;

import java.util.List;

import com.gyan.basic.model.Formdata;

public interface FormdataDAO {

	public void addFormdata(Formdata p);
	public void updateFormdata(Formdata p);
	public List<Formdata> listFormdatas();
	public Formdata getFormdataById(int id);
	public void removeFormdata(int id);
}
