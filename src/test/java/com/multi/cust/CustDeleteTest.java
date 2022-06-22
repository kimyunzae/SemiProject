package com.multi.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;

@SpringBootTest
class CustDeleteTest {
	
	@Autowired
	CustBiz biz;

	@Test
	void contextLoads() {
		try {
			biz.remove(null);
			System.out.println("Delete OK");
		} catch (Exception e) {
			System.out.println("Delete FAIL");
			e.printStackTrace();
		}
	}

}
