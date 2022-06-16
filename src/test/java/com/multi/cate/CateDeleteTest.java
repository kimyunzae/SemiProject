package com.multi.cate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CateBiz;

@SpringBootTest
class CateDeleteTest {
	
	@Autowired
	CateBiz biz;

	@Test
	void contextLoads() {
		try {
			biz.remove(12);
			System.out.print("Delete OK");
		} catch (Exception e) {
			System.out.print("Delete FAIL");
			e.printStackTrace();
		}
	}

}
