package com.boraji.tutorial.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.boraji.tutorial.spring.model.User;
import com.boraji.tutorial.spring.service.CacdlgService;
import com.boraji.tutorial.spring.service.UserService;

/**
 * @author imssbora
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CacdlgService cacdlgService;

	@GetMapping("/")
	public String userForm(Locale locale, Model model) {

		model.addAttribute("user", new User());
		model.addAttribute("users", userService.list());
		model.addAttribute("countryList", cacdlgService.getCacdlgMap());

		return "userForm";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("users", userService.list());
			return "userForm";
		}

		userService.save(user);
		
		return "redirect:/";
	}
	
	@ModelAttribute("countryList")
	   public Map<String, String> getCountryList() {
		return cacdlgService.getCacdlgMap();	
//	      Map<String, String> countryList = new HashMap<String, String>();
//	      countryList = CacdlgService.
//	      countryList.put("US", "United States");
//	      countryList.put("CH", "China");
//	      countryList.put("SG", "Singapore");
//	      countryList.put("MY", "Malaysia");
//	      return countryList;
	   }
	
}
