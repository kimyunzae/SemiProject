package com.multi.orderdetail;

import java.util.List; 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.OrderdetailBiz;
import com.multi.vo.OrderdetailVO;

@SpringBootTest
class OrderdetailSelectAllTest {
	
	@Autowired
	OrderdetailBiz biz;
	
	@Test
	void contextLoads() {
		List<OrderdetailVO> list = null;
		try {
			list = biz.get();
			System.out.println("SelectAll OK");
			for (OrderdetailVO obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


