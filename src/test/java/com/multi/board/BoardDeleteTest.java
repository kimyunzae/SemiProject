package com.multi.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BoardBiz;

@SpringBootTest
class BoardDeleteTest {
	
	@Autowired
	BoardBiz biz;
	
	@Test
	void contextLoads() {
		try {
			biz.remove(6);
			System.out.print("Delete OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


