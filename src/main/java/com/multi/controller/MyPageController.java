package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.AddrlistBiz;
import com.multi.biz.CustBiz;
import com.multi.vo.AddrlistVO;
import com.multi.vo.CustVO;

@Controller
public class MyPageController {

	@Autowired
	CustBiz biz;
	
	@Autowired
	AddrlistBiz abiz;
	

	@RequestMapping("/mypage")
	public String mypage(Model m, HttpSession session) {
		m.addAttribute("center", "mypage/mypage");
		CustVO vo = (CustVO) session.getAttribute("logincust");
		try {
			List<AddrlistVO> aidsoncust = abiz.getpercust(vo.getUid());
			m.addAttribute("aidsoncust",aidsoncust);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
