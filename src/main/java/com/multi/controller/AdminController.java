package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CateBiz;
import com.multi.biz.ProductBiz;
import com.multi.frame.Util;
import com.multi.vo.CateVO;
import com.multi.vo.ProductVO;


@Controller
public class AdminController {

	@Autowired
	CateBiz cabiz;

	@Autowired
	ProductBiz pbiz;

	@Value("${admindir}")
	String admindir;

	// ************************** ADMIN SECTION **************************
		@RequestMapping("/admin")
		public String admin(Model m) {
			List<CateVO> list = null;
			try {
				list = cabiz.get();
				m.addAttribute("center", "admin/admin");
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

		
		@RequestMapping("/productlist")
		public String productlist(Model m) {
			List<ProductVO> list = null;
			try {
				list = pbiz.get();
				m.addAttribute("plist", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			m.addAttribute("center", "admin/productlist");
			return "/index";
		}
		
		@RequestMapping("/detail")
		public String detail(Model m, int id) {
			ProductVO obj = null;
			List<CateVO> list = null;
			try {
				list = cabiz.get();
				m.addAttribute("clist", list);
				obj = pbiz.get(id);
				m.addAttribute("dp", obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
			m.addAttribute("center", "admin/productdetail");
			return "/index";
		}
		
		@RequestMapping("/update")
		public String update(Model m, ProductVO p) {
		
			String iname = p.getMf().getOriginalFilename();
			if(!(iname.equals(""))) {
				p.setPimgname(iname);
				Util.saveFile(p.getMf(),admindir);
			}
			try {
				pbiz.modify(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "redirect:productlist";
		}
		
		@RequestMapping("/deleteimpl")
		public String deleteimpl(Model m, int id) {
			try {
				pbiz.remove(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:productlist";
		}
			
}
