package com.multi.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.biz.ProductBiz;
import com.multi.vo.CustVO;
import com.multi.vo.ProductVO;

@SpringBootTest
class ProductSelectTest {
	
	@Autowired
	ProductBiz biz;
	
	@Test
	void contextLoads() {
		ProductVO obj = null;
		try {
			obj = biz.get(1003);
			System.out.println("Select OK");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


