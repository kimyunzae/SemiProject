package com.multi.cate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CateBiz;
import com.multi.vo.CateVO;

@SpringBootTest
class CateInsertTest {
	
	@Autowired
	CateBiz biz;

	@Test
	void contextLoads() {
		CateVO obj = new CateVO(60,"new");
		try {
			biz.register(obj);
			System.out.println("Registered OK");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
