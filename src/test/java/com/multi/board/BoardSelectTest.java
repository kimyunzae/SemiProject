package com.multi.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BoardBiz;
import com.multi.vo.BoardVO;

@SpringBootTest
class BoardSelectTest {
	
	@Autowired
	BoardBiz biz;
	
	@Test
	void contextLoads() {
		BoardVO obj = null;
		try {
			obj = biz.get(1);	
				System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


