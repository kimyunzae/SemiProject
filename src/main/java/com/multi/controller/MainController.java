package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CateBiz;
import com.multi.biz.CustBiz;
import com.multi.biz.OrderdBiz;
import com.multi.biz.OrderdetailBiz;
import com.multi.biz.ProductBiz;
import com.multi.vo.CustVO;
import com.multi.vo.OrderdetailVO;

@Controller
public class MainController {

	@Autowired
	CustBiz custbiz;

	@Autowired
	CateBiz cabiz;

	@Autowired
	ProductBiz pbiz;

	@Value("${admindir}")
	String admindir;

	@Autowired
	OrderdBiz obiz;
	
	@Autowired
	OrderdetailBiz odbiz;

	@RequestMapping("/index")
	public String index(Model m) {
		return "index";
	}

	@RequestMapping("/about")
	public String about(Model m) {
		m.addAttribute("center", "about");
		return "index";
	}

	@RequestMapping("/store")
	public String store(Model m) {
		m.addAttribute("center", "store");
		return "index";
	}


	@RequestMapping("/register")
	public String register(Model m) {
		m.addAttribute("center", "register");
		return "index";
	}

	@RequestMapping("/registerimpl")
	public String registerimpl(Model m, CustVO cust, HttpSession session) {
		try {
			if(cust != null) {
			custbiz.register(cust);
			session.setAttribute("logincust", cust);
			}
			else {

				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping("/login")
	public String login(Model m,String msg) {
		m.addAttribute("center", "login");
		m.addAttribute("msg",msg);
		return "index";
	}

	@RequestMapping("/logout")
	public String logout(Model m, HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		return "index";
	}

	@RequestMapping("/loginimpl")
	public String loginimpl(Model m, HttpSession session, String id, String pwd) {
		CustVO cust = null;
		// String loginfail = "Login Failed";
		
		try {
			cust = custbiz.get(id);
			if (cust == null) {
				throw new Exception();
			}
			
			if (cust.getPwd().equals(pwd)) {
				session.setAttribute("logincust", cust);
				
				if(cust.getUid().equals("id01")) {
					session.setAttribute("loginadmin", cust);
				}
				
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
		//	m.addAttribute("loginfail", loginfail);
			return "redirect:/login?msg=f";
		}
		return "index";
	}

}