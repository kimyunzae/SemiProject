package com.multi.orderd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.OrderdBiz;

@SpringBootTest
class OrderdDeleteTest {
	
	@Autowired
	OrderdBiz biz;

	@Test
	void contextLoads() {
		try {
			biz.remove(3);
			System.out.println("Delete OK");
		} catch (Exception e) {
			System.out.println("Delete FAIL");
			e.printStackTrace();
		}
	}

}
