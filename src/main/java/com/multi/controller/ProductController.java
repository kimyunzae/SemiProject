package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CartBiz;
import com.multi.biz.CateBiz;
import com.multi.biz.ProductBiz;
import com.multi.vo.CartVO;
import com.multi.vo.CateVO;
import com.multi.vo.ProductVO;

@Controller
public class ProductController {

	@Autowired
	CateBiz cabiz;

	@Autowired
	ProductBiz pbiz;
	
	@Autowired
	CartBiz crbiz;

	@RequestMapping("/products")
	public String products(Model m) {
		List<CateVO> catelist = null;
		List<ProductVO> plist = null;

		try {
			catelist = cabiz.get();
			plist = pbiz.get();
			m.addAttribute("center", "products");
			m.addAttribute("catelist", catelist);
			m.addAttribute("plist", plist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping("getproduct")
	public String getproduct(Model m, int id, String name) {
		List<CateVO> catelist = null;
		List<ProductVO> plist = null;
		try {
			catelist = cabiz.get();
			plist = pbiz.selectproduct(id);
			m.addAttribute("center", "products");
			m.addAttribute("menu", name);
			m.addAttribute("catelist", catelist);
			m.addAttribute("plist", plist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	
	@RequestMapping("/addtobag")
	public String addtobag(Model m, String uid, int pid) {
		CartVO obj = new CartVO(null,uid,pid,2); 
		try {
			crbiz.register(obj);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}

	

}
