package com.multi.orderd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.OrderdBiz;
import com.multi.vo.OrderdVO;

@SpringBootTest
class OrderdInsertTest {
	
	@Autowired
	OrderdBiz biz;

	@Test
	void contextLoads() {
		OrderdVO obj = new OrderdVO("id04",0,"인천","김상민","departing","ZF124392058120");
		try {
			biz.register(obj);
			System.out.println("Registered OK");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
