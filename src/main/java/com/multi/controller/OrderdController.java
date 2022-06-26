package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CartBiz;
import com.multi.biz.CustBiz;
import com.multi.biz.OrderdBiz;
import com.multi.vo.CartVO;
import com.multi.vo.CustVO;
import com.multi.vo.OrderdVO;

@Controller
public class OrderdController {

	@Autowired
	OrderdBiz orbiz;
	
	@Autowired
	CartBiz cbiz;

	@Autowired
	CustBiz cubiz;


	@RequestMapping("/orderd")
	public String orderd(Model m, HttpSession session) {
		
		List<CartVO> cartlist = null;  	
		CustVO vo = (CustVO) session.getAttribute("logincust");
		String uid = vo.getUid();
		try {
			
			cartlist = cbiz.selectp(uid);
			vo = cubiz.get(uid);

			m.addAttribute("center", "orderd");
		
			m.addAttribute("cartlist", cartlist);   
			m.addAttribute("vo", vo);    

		} catch (Exception e) {
			e.printStackTrace();

		}

		return "index";
	}
	
}
