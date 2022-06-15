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
		return "about";
	}

	@RequestMapping("/products")
	public String products(Model m) {
		return "products";
	}

	@RequestMapping("/store")
	public String store(Model m) {
		return "store";
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
