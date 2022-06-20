package com.multi.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CartBiz;
import com.multi.vo.CartVO;

@SpringBootTest
class CartInsertTest {
	
	@Autowired
	CartBiz biz;
	
	@Test
	void contextLoads() {
		CartVO obj = new CartVO(2,"id05",1001, 5);
		try {
			biz.register(obj);
			System.out.println("Registered OK");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


