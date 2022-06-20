package com.multi.addrlist;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CartBiz;
import com.multi.biz.CustBiz;
import com.multi.vo.CartVO;
import com.multi.vo.CustVO;

@SpringBootTest
class CartSelectAllTest {
	
	@Autowired
	CartBiz biz;
	
	@Test
	void contextLoads() {
		List<CartVO> list = null;
		try {
			list = biz.get();
			for (CartVO obj : list) {
				System.out.print("SelectAll OK");
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


