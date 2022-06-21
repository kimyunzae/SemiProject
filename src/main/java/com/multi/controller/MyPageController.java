package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.AddrlistBiz;
import com.multi.biz.CustBiz;

@Controller
public class MyPageController {

	@Autowired
	CustBiz biz;
	
	@Autowired
	AddrlistBiz abiz;
	

	@RequestMapping("/mypage")
	public String mypage(Model m) {
		m.addAttribute("center", "mypage/mypage");
		m.addAttribute("center2", "mypage/profile");
		return "index";
	}
	
	@RequestMapping("/address")
	public String address(Model m) {
		m.addAttribute("center", "mypage/mypage");
		m.addAttribute("center2", "mypage/address");
		return "index";
	}
	
	
	@RequestMapping("/orders")
	public String orders(Model m) {
		m.addAttribute("center", "mypage/mypage");
		m.addAttribute("center2", "mypage/orders");
		return "index";
	}
	
	@RequestMapping("/activities")
	public String activities(Model m) {
		m.addAttribute("center", "mypage/mypage");
		m.addAttribute("center2", "mypage/activities");
		return "index";
	}
	
	

}
