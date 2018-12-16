package com.boraji.tutorial.spring.service;

import java.util.List;
import java.util.Map;

import com.boraji.tutorial.spring.model.Cacdlg;

public interface CacdlgService {
   void saveCacdlg(Cacdlg cacdlg);

   List<Cacdlg> listCacdlg();

   Map<String, String> getCacdlgMap();
}
