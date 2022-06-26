package com.multi.controller;

import java.util.List;

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
	public String orderd(Model m, String id) {
		
		List<CartVO> cartlist = null;  	
		CustVO custlist = null;
		
		try {
			cartlist = cbiz.selectp();
			custlist = cubiz.get(id);

			m.addAttribute("center", "orderd");
			m.addAttribute("cartlist", cartlist);   
			m.addAttribute("custlist", custlist);    

		} catch (Exception e) {
			e.printStackTrace();

		}

		return "index";
	}
	
	@RequestMapping("/addorder")
	public String addorder(Model m, String uid, int totalprice,
			String addr, String receiver, String transaction) {
		transaction = "Credit Card";
		OrderdVO obj = 
				new OrderdVO(uid,
						totalprice, addr, receiver, 
						"pending", transaction); 
		try {
			orbiz.register(obj);
			m.addAttribute("center", "orderok");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}

	
}
