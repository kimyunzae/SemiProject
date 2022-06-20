package com.multi.orderdetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.OrderdetailBiz;

@SpringBootTest
class OrderdetailDeleteTest {
	
	@Autowired
	OrderdetailBiz biz;

	@Test
	void contextLoads() {
		try {
			biz.remove(5);
			System.out.println("Delete OK");
		} catch (Exception e) {
			System.out.println("Delete FAIL");
			e.printStackTrace();
		}
	}
}
