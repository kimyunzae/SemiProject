package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.CartBiz;
import com.multi.biz.CustBiz;
import com.multi.vo.CartVO;
import com.multi.vo.CustVO;

@RestController
public class AJAXController {

	@Autowired
	CustBiz biz;
	
	@Autowired
	CartBiz cartbiz;
	
	
	
	
	
}









