package com.multi.orderd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.OrderdBiz;
import com.multi.vo.OrderdVO;

@SpringBootTest
class OrderdUpdateTest {
	
	@Autowired
	OrderdBiz biz;

	@Test
	void contextLoads() {
		OrderdVO obj = new OrderdVO(3,"id04",300,"인천","민상김","delivered");
		try {
			biz.modify(obj);
			System.out.println("Update OK");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
