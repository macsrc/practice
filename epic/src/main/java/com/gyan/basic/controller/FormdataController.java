package com.gyan.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gyan.basic.model.Formdata;
import com.gyan.basic.service.FormdataService;

@Controller
public class FormdataController {
	
	private FormdataService formdataService;
	
	@Autowired(required=true)
	@Qualifier(value="formdataService")
	public void setFormdataService(FormdataService ps){
		this.formdataService = ps;
	}
	
	@RequestMapping(value = "/formdatas", method = RequestMethod.GET)
	public String listFormdatas(Model model) {
		model.addAttribute("formdata", new Formdata());
		model.addAttribute("listFormdatas", this.formdataService.listFormdatas());
		return "formdata";
	}
	
	//For add and update formdata both
	@RequestMapping(value= "/formdata/add", method = RequestMethod.POST)
	public String addFormdata(@ModelAttribute("formdata") Formdata p){
		
		if(p.getId() == 0){
			//new formdata, add it
			this.formdataService.addFormdata(p);
		}else{
			//existing formdata, call update
			this.formdataService.updateFormdata(p);
		}
		
		return "redirect:/formdatas";
		
	}
	
	@RequestMapping("/fdremove/{id}")
    public String removeFormdata(@PathVariable("id") int id){
		
        this.formdataService.removeFormdata(id);
        return "redirect:/formdatas";
    }
 
    @RequestMapping("/fdedit/{id}")
    public String editFormdata(@PathVariable("id") int id, Model model){
        model.addAttribute("formdata", this.formdataService.getFormdataById(id));
        model.addAttribute("listFormdatas", this.formdataService.listFormdatas());
        return "formdata";
    }
	
}
