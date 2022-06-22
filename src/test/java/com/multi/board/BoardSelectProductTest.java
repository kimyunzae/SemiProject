package com.multi.board;

// product id를 입력하면 관련 게시물이 뜨도록 

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BoardBiz;
import com.multi.vo.BoardVO;

@SpringBootTest
class BoardSelectProductTest {
	
	@Autowired
	BoardBiz biz;
	
	@Test
	void contextLoads() {
		List<BoardVO> obj = null;
		try {
			obj = biz.getboard(1001);	
				System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


