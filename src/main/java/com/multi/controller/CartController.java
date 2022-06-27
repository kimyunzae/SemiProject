package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CartBiz;
import com.multi.vo.CartVO;
import com.multi.vo.CustVO;

@Controller
public class CartController {

	@Autowired
	CartBiz cbiz;

	@RequestMapping("/cart")
	public String cart(Model m, HttpSession session) {
		List<CartVO> cartlist = null;
		try {
			CustVO vo = (CustVO) session.getAttribute("logincust");
			if (vo == null) {
				throw new NotLoggedInException();
			}
			String uid = vo.getUid();
			cartlist = cbiz.selectp(uid);
			m.addAttribute("center", "cart");
			m.addAttribute("cartlist", cartlist);
		} catch (NotLoggedInException l) {
			return "redirect:/login";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping("/cartupdate")
	public String cartupdate(int crid, String pm, HttpSession session) throws Exception {
		if (session == null) {
			throw new Exception();
		}
		CartVO vo = cbiz.get(crid);
		if (pm.equals("p")) {
			vo.setCnt(vo.getCnt() + 1);
			cbiz.modify(vo);
			return "redirect:cart";
		} else if (pm.equals("m")) {
			vo.setCnt(vo.getCnt() - 1);
			cbiz.modify(vo);
			return "redirect:cart";
		} else {
			throw new Exception();
		}
	}

	@RequestMapping("/delete")
	public String deletebtn(Integer crid, Model m) {
		try {
			cbiz.remove(crid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:cart";
	}

}
