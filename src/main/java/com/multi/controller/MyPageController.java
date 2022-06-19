package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CustBiz;

@Controller
public class MyPageController {

	@Autowired
	CustBiz biz;
	
	@RequestMapping("/mypage")
	public String mypage(Model m) {
		m.addAttribute("center","mypage");
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









