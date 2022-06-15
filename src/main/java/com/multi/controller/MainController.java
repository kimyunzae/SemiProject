package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/index")
	public String index(Model m) {
		return "index";
	}

	@RequestMapping("/about")
	public String about(Model m) {
		m.addAttribute("center","about");
		return "index";
	}

	@RequestMapping("/products")
	public String products(Model m) {
		m.addAttribute("center","products");
		return "index";
	}

	@RequestMapping("/store")
	public String store(Model m) {
		m.addAttribute("center","store");
		return "index";
	}
	
	@RequestMapping("/register")
	public String register(Model m) {
		return "register";
	}
	
	@RequestMapping("/login")
	public String login(Model m) {
		return "login";
	}

}
