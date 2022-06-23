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
import com.multi.biz.ProductBiz;
import com.multi.frame.Util;
import com.multi.vo.CateVO;
import com.multi.vo.CustVO;
import com.multi.vo.ProductVO;

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

	@RequestMapping("/cart")
	public String cart(Model m) {
		m.addAttribute("center", "cart");
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
			custbiz.register(cust);
			session.setAttribute("logincust", cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping("/login")
	public String login(Model m) {
		m.addAttribute("center", "login");
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
		try {
			cust = custbiz.get(id);
			if (cust == null) {
				throw new Exception();
			}
			if (cust.getPwd().equals(pwd)) {
				session.setAttribute("logincust", cust);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {

			return "redirect:/login?msg=f";
		}
		return "index";
	}

	@RequestMapping("/admin")
	public String admin(Model m) {
		List<CateVO> list = null;
		try {
			list = cabiz.get();
			m.addAttribute("center", "admin");
			m.addAttribute("clist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping("/addimpl")
	public String addimpl(Model m, ProductVO p) {
		String imgname = p.getMf().getOriginalFilename();
		p.setPimgname(imgname);

		try {
			pbiz.register(p);
			Util.saveFile(p.getMf(), admindir);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:products";
	}

	@RequestMapping("catecheckid")
	public String catecheckid(String id) {

		String result = "";
		CateVO c = null;

		if (id.equals("") || id == null) {
			return "1";
		}

		try {
			c = cabiz.get(Integer.parseInt(id));
			if (c == null) {
				result = "0";
			} else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping("/cateaddimpl")
	public String cateaddimpl(Model m, CateVO c) {
		try {
			cabiz.register(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:products";
	}

}
