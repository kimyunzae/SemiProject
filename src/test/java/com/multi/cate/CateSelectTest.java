package com.multi.cate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CateBiz;
import com.multi.biz.CustBiz;
import com.multi.vo.CateVO;
import com.multi.vo.CustVO;

@SpringBootTest
class CateSelectTest {
	
	@Autowired
	CateBiz biz;
	
	@Test
	void contextLoads() {
		CateVO obj = null;
		try {
			obj = biz.get(5);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


