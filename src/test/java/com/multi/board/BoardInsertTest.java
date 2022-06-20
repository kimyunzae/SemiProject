package com.multi.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BoardBiz;
import com.multi.vo.BoardVO;

@SpringBootTest
class BoardInsertTest {
	
	@Autowired
	BoardBiz biz;
	
	@Test
	void contextLoads() {
		BoardVO obj = new BoardVO(0,1004,"가위","가위바위","가위바위보");
		try {
			biz.register(obj);
			System.out.println("Registered OK");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


