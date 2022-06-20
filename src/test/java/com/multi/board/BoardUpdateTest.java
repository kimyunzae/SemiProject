package com.multi.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BoardBiz;
import com.multi.vo.BoardVO;

@SpringBootTest
class BoardUpdateTest {
	
	@Autowired
	BoardBiz biz;
	
	@Test
	void contextLoads() {
		BoardVO obj = new BoardVO(5,1005,"good5","id05","goooood");
		try {
			biz.modify(obj);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


