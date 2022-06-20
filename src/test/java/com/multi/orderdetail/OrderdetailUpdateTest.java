package com.multi.orderdetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.OrderdetailBiz;
import com.multi.vo.OrderdetailVO;

@SpringBootTest
class OrderdetailUpdateTest {
	
	@Autowired
	OrderdetailBiz biz;

	@Test
	void contextLoads() {
		OrderdetailVO obj = new OrderdetailVO(5,4,1000,100,"coffee0",2);
		try {
			biz.modify(obj);
			System.out.println("Update OK");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
