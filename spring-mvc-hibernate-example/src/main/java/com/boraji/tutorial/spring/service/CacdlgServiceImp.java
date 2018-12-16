package com.boraji.tutorial.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.CommonDao;
import com.boraji.tutorial.spring.model.Cacdlg;

@Service
public class CacdlgServiceImp implements CacdlgService {

	@Autowired
	private CommonDao commonDao;

	@Transactional
	public void saveCacdlg(Cacdlg cacdlg) {
		commonDao.save(cacdlg);
	}

	@Transactional(readOnly = true)
	public List<Cacdlg> listCacdlg() {
		return commonDao.listCacdlg();
	}

	@Transactional(readOnly = true)
	public Map<String, String> getCacdlgMap() {
		Map<String, String> cdlgMap = new HashMap<String, String>();

		List<Cacdlg> cdlgList = commonDao.listCacdlg();
		for (Cacdlg cdlg : cdlgList) {
			cdlgMap.put(cdlg.getCDLG_CODE(), cdlg.getCDLG_CODE_NAME());
		}

		return cdlgMap;
	}

}
