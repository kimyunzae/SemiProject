package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.CartBiz;
import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@RestController
public class AJAXController {

	@Autowired
	CustBiz biz;
	
	@Autowired
	CartBiz cartbiz;
	
	@RequestMapping("checkuid")
	public String checkuid(String uid) {
		
		String result = "";
		CustVO c = null;
		
		if(uid.equals("") || uid == null) {
			return "1";
		}
		
		try {
			c = biz.get(uid);
			if(c == null) {
				result = "0";
			}else{
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	

	
	
	
}








