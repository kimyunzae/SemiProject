package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CartBiz;
import com.multi.vo.CartVO;

@Controller
public class CartController {

	@Autowired
	CartBiz cbiz;

	
	  @RequestMapping("/cart")
	   public String cart(Model m) {
	      List<CartVO> cartlist = null;   
	      try {
	    	  cartlist = cbiz.selectp();
	         m.addAttribute("center", "cart");
	         m.addAttribute("cartlist", cartlist);    
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return "index";
	   }
	   
	   @RequestMapping("/delete")
	   public String deletebtn(Integer crid,Model m) {  
	      try {
	    	  cbiz.remove(crid);   
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return "redirect:cart";
	   }
	
	
	
	
	

	

}
