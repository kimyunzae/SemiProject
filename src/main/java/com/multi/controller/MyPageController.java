package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.AddrlistBiz;
import com.multi.biz.CustBiz;
import com.multi.biz.OrderdBiz;
import com.multi.vo.AddrlistVO;
import com.multi.vo.CustVO;
import com.multi.vo.OrderdVO;


@Controller
public class MyPageController {

	@Autowired
	CustBiz biz;

	@Autowired
	AddrlistBiz abiz;
	
	@Autowired
	OrderdBiz obiz;

	@RequestMapping("/mypage")
	public String mypage(Model m, HttpSession session) {
		m.addAttribute("center", "mypage/mypage");
		CustVO vo = (CustVO) session.getAttribute("logincust");
		String uid = vo.getUid();
		try {
			vo = biz.get(uid);
			List<AddrlistVO> aidsoncust = abiz.getpercust(uid);
			m.addAttribute("vo",vo);
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
		List<AddrlistVO> addrlist = null;
		try {
			addrlist = abiz.get();
			m.addAttribute("center", "mypage/mypage");
			m.addAttribute("center2", "mypage/address");
			m.addAttribute("addrlist", addrlist);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}

	   @RequestMapping("/orders")
	   public String orders(Model m) {
	      List<OrderdVO> orderd = null;
	      try {
	         orderd = obiz.get();
	         m.addAttribute("center", "mypage/mypage");
	         m.addAttribute("center2", "mypage/orders");
	         m.addAttribute("orderd",orderd);
	      } catch (Exception e) {
	      
	         e.printStackTrace();
	      }
	      
	      return "index";
	   }
	   
	@RequestMapping("/activities")
	public String activities(Model m) {
		m.addAttribute("center", "mypage/mypage");
		m.addAttribute("center2", "mypage/activities");
		return "index";
	}
	
	

}
