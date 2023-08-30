package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeControllers {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String indexMethod(Model model)
	{
		model.addAttribute("Name", "Naren");
		return "index";
	}
}
