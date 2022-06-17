package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@Controller
public class MainController {
	
	@Autowired
	CustBiz custbiz;

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
		m.addAttribute("center","register");
		return "index";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model m, CustVO cust, HttpSession session) {
		try {
			custbiz.register(cust);
			session.setAttribute("logincust", cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Model m) {
		m.addAttribute("center","login");
		return "index";
	}
	
	
	@RequestMapping("/loginimpl")
	public String loginimpl(Model m, HttpSession session, String id, String pwd) {
		CustVO cust = null;
		try {
			cust = custbiz.get(id);
			if(cust == null) {
				throw new Exception();
			}
			if(cust.getPwd().equals(pwd)) {
				session.setAttribute("logincust", cust);
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			return "redirect:/login";
		}
		return "index";
	}
	
	@RequestMapping("/logout")
	public String logout(Model m, HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		return "index";
	}

	
	
}
