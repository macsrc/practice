package com.gyan.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gyan.basic.model.Formdata;
import com.gyan.basic.service.FormdataService;

@Controller
public class HomeController {

	private FormdataService formdataService;

	@Autowired(required = true)
	@Qualifier(value = "formdataService")
	public void setFormdataService(FormdataService ps) {
		this.formdataService = ps;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listFormdatas(Model model) {
		model.addAttribute("formdata", new Formdata());
		model.addAttribute("listFormdatas", this.formdataService.listFormdatas());
		return "formdata";
	}

}
