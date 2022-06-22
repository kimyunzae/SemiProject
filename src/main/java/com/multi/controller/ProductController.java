package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CateBiz;
import com.multi.biz.ProductBiz;
import com.multi.vo.CateVO;
import com.multi.vo.ProductVO;

@Controller
public class ProductController {

	@Autowired
	ProductBiz pbiz;
	
	@Autowired
	CateBiz cabiz;
	

	@RequestMapping("/catelist")
	public  List<CateVO> makemenu(Model m) {
		List<CateVO> catelist = null;
		try {
			catelist = cabiz.getmain();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return catelist;
	}
	
	
	
	

}
