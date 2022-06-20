package com.multi.orderdetail;

import org.junit.jupiter.api.Test; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.OrderdetailBiz;
import com.multi.vo.OrderdetailVO;

@SpringBootTest
class OrderdetailSelectTest {
	
	@Autowired
	OrderdetailBiz biz;
	
	@Test
	void contextLoads() {
		OrderdetailVO obj = null;
		try {
			obj = biz.get(1);
			System.out.println("Select OK");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


