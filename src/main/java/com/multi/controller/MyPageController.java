package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.multi.biz.AddrlistBiz;
import com.multi.biz.BoardBiz;
import com.multi.biz.CustBiz;
import com.multi.biz.OrderdBiz;
import com.multi.vo.AddrlistVO;
import com.multi.vo.BoardVO;
import com.multi.vo.CustVO;
import com.multi.vo.OrderdVO;

@Controller
public class MyPageController {

	@Autowired
	CustBiz biz;

	@Autowired
	AddrlistBiz abiz;

	@Autowired
	OrderdBiz obiz;

	@Autowired
	BoardBiz bobiz;

	@RequestMapping("/mypage")
	public String mypage(Model m, HttpSession session) {
		m.addAttribute("center", "mypage/mypage");
		try {
			CustVO vo = (CustVO) session.getAttribute("logincust");
			if (vo == null) {
				throw new NotLoggedInException();
			}
			String uid = vo.getUid();
			vo = biz.get(uid);
			List<AddrlistVO> aidsoncust = abiz.getpercust(uid);
			m.addAttribute("vo", vo);
			m.addAttribute("aidsoncust", aidsoncust);
		} catch (NotLoggedInException l) {
			return "redirect:/login";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.addAttribute("center2", "mypage/profile");
		return "index";
	}

	@RequestMapping("/profile_update")
	public RedirectView profile_update(Model m, CustVO vo) {
		try {
			biz.modify(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RedirectView("/mypage");
	}

	@RequestMapping("/defaddr_update")
	public RedirectView defaddr_update(Model m, CustVO vo) {
		try {
			biz.modifyDefShipAddr(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RedirectView("/address");
	}

	@RequestMapping("/add_addr")
	public RedirectView add_addr(Model m, AddrlistVO vo) {
		try {
			abiz.register(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RedirectView("/address");
	}

	@RequestMapping("/address")
	public String address(Model m, HttpSession session) {
		List<AddrlistVO> addrlist = null;
		try {
			CustVO vo = (CustVO) session.getAttribute("logincust");
			if (vo == null) {
				throw new NotLoggedInException();
			}
			String uid = vo.getUid();
			vo = biz.get(uid);
			addrlist = abiz.getpercust(uid);
			m.addAttribute("vo", vo);
			m.addAttribute("center", "mypage/mypage");
			m.addAttribute("center2", "mypage/address");
			m.addAttribute("addrlist", addrlist);
		} catch (NotLoggedInException l) {
			return "redirect:/login";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}

	@RequestMapping("/orders")
	public String orders(Model m) {
		List<OrderdVO> orderd = null;
		try {
			orderd = obiz.get();
			m.addAttribute("center", "mypage/mypage");
			m.addAttribute("center2", "mypage/orders");
			m.addAttribute("orderd", orderd);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return "index";
	}

	@RequestMapping("/activities")
	public String activities(Model m) {
		List<BoardVO> board = null;
		try {
			board = bobiz.get();
			m.addAttribute("center", "mypage/mypage");
			m.addAttribute("center2", "mypage/activities");
			m.addAttribute("board", board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

}
