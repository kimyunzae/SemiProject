package com.multi.orderd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.OrderdBiz;
import com.multi.vo.OrderdVO;

@SpringBootTest
class OrderdUpdatetotalpriceTest {
	
	@Autowired
	OrderdBiz biz;

	@Test
	void contextLoads() {
		try {
			int updatingOrderd = 4;
			biz.sumTotalprice(updatingOrderd);
			System.out.println("Total price Update OK");
			System.out.println(biz.get(updatingOrderd));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
