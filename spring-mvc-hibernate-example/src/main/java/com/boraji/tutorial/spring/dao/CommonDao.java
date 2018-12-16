package com.boraji.tutorial.spring.dao;

import java.util.List;
import java.util.Map;

import com.boraji.tutorial.spring.model.Cacdlg;

public interface CommonDao {
   void save(Cacdlg obj);
   void update(Object obj);
   void delete(int objId);
   List<Cacdlg> listCacdlg();
}
