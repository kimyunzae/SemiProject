package com.multi.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@SpringBootTest
class CustUpdateTest {
	
	@Autowired
	CustBiz biz;

	@Test
	void contextLoads() {
		CustVO obj = new CustVO("id05","이진만","서울","pwd05", "abc@naver.com", "01011112222",null);
		try {
			biz.modify(obj);
			System.out.println("Update OK");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
