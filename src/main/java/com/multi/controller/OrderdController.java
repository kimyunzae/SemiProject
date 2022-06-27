package com.multi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CartBiz;
import com.multi.biz.CustBiz;
import com.multi.biz.OrderdBiz;
import com.multi.biz.OrderdetailBiz;
import com.multi.biz.ProductBiz;
import com.multi.vo.CartVO;
import com.multi.vo.CustVO;
import com.multi.vo.OrderdVO;
import com.multi.vo.OrderdetailVO;
import com.multi.vo.ProductVO;

@Controller
public class OrderdController {

	@Autowired
	OrderdBiz orbiz;

	@Autowired
	CartBiz cbiz;

	@Autowired
	CustBiz cubiz;

	@Autowired
	ProductBiz pbiz;

	@Autowired
	OrderdetailBiz odbiz;

	@RequestMapping("/orderd")
	public String orderd(Model m, HttpSession session, Integer ipid, Integer icnt) {
		List<CartVO> cartlist = null;
		try {
			CustVO custvo = (CustVO) session.getAttribute("logincust");
			String uid = custvo.getUid();
			custvo = cubiz.get(uid);
			if (ipid != null && icnt != null) {
				ProductVO productvo = pbiz.get(ipid);
				CartVO cartvo = new CartVO(null, uid, ipid, icnt, productvo.getPprice(), productvo.getPimgname(),
						productvo.getPname());
				cartlist = new ArrayList<CartVO>();
				cartlist.add(cartvo);
				session.setAttribute("onlyoneproduct", cartvo);
			} else {
				cartlist = cbiz.selectp(uid);
			}
			m.addAttribute("center", "orderd");
			m.addAttribute("cartlist", cartlist);
			m.addAttribute("custvo", custvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping("/addorder")
	public String addorder(Model m, String addr, String receivename, String transaction, HttpSession session) {
		try {
			CustVO custvo = (CustVO) session.getAttribute("logincust");
			String uid = custvo.getUid();
			custvo = cubiz.get(uid);

			OrderdVO orderdvo = new OrderdVO(uid, 0, addr, receivename, "pending", transaction);
			orbiz.register(orderdvo);
			int orid = orderdvo.getOrid();

			int totalprice = 0;
			List<CartVO> cartlist = null;
			if ((CartVO) session.getAttribute("onlyoneproduct") != null) {
				CartVO cart = (CartVO) session.getAttribute("onlyoneproduct");
				cartlist = new ArrayList<CartVO>();
				cartlist.add(cart);
			} else {
				cartlist = cbiz.selectp(uid);
			}
			for (CartVO cart : cartlist) {
				int pid = cart.getPid();
				int cnt = cart.getCnt();
				OrderdetailVO odvo = new OrderdetailVO(orid, pid, cnt);
				odbiz.register(odvo);
				int pprice = pbiz.get(pid).getPprice();
				totalprice += pprice * cnt;
			}
			// public OrderdVO(Integer orid, String uid, int totalprice, String addr, String
			// receivename, String status)
			OrderdVO priceupdater = new OrderdVO(orid, uid, totalprice, null, null, null);
			if ((CartVO) session.getAttribute("onlyoneproduct") != null) {
				session.removeAttribute("onlyoneproduct");
			} else {
				for (CartVO cart : cartlist) {
					int cid = cart.getCrid();
					cbiz.remove(cid);
				}
			}
			orbiz.modify(priceupdater);
			m.addAttribute("center", "orderok");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}

	@RequestMapping("/buy")
	public String buy(Model m) {

		try {

			m.addAttribute("center", "orderok");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}

	@RequestMapping("/orderok")
	public String orderok(Model m) {
		List<OrderdVO> orderd = null;

		try {
			orderd = orbiz.get();

			m.addAttribute("center", "orderok");
			m.addAttribute("orderd", orderd);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return "index";
	}

}
