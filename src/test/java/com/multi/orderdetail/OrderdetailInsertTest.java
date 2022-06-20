package com.multi.orderdetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.OrderdetailBiz;
import com.multi.vo.OrderdetailVO;

@SpringBootTest
class OrderdetailInsertTest {
	
	@Autowired
	OrderdetailBiz biz;

	@Test
	void contextLoads() {
		OrderdetailVO obj = new OrderdetailVO(4,1002,3);
		try {
			biz.register(obj);
			System.out.println("Registered OK");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
