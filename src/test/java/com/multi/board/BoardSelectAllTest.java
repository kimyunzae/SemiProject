package com.multi.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BoardBiz;
import com.multi.vo.BoardVO;

@SpringBootTest
class BoardSelectAllTest {
	
	@Autowired
	BoardBiz biz;
	
	@Test
	void contextLoads() {
		List<BoardVO> list = null;
		try {
			list = biz.get();
			for (BoardVO obj : list) {
				System.out.print("SelectAll OK");
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


