package com.multi.orderd;

import org.junit.jupiter.api.Test; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.OrderdBiz;
import com.multi.vo.OrderdVO;

@SpringBootTest
class OrderdSelectTest {
	
	@Autowired
	OrderdBiz biz;
	
	@Test
	void contextLoads() {
		OrderdVO obj = null;
		try {
			obj = biz.get(10);
			System.out.println("Select OK");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


