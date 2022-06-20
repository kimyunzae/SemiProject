package com.multi.orderd;

import java.util.List; 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.OrderdBiz;
import com.multi.vo.OrderdVO;

@SpringBootTest
class OrderdSelectAllTest {
	
	@Autowired
	OrderdBiz biz;
	
	@Test
	void contextLoads() {
		List<OrderdVO> list = null;
		try {
			list = biz.get();
			System.out.println("SelectAll OK");
			for (OrderdVO obj : list) {				
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


