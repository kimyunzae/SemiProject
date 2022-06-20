package com.multi.addrlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AddrlistBiz;
import com.multi.biz.CateBiz;
import com.multi.biz.CustBiz;
import com.multi.vo.AddrlistVO;
import com.multi.vo.CateVO;
import com.multi.vo.CustVO;

@SpringBootTest
class AddrlistSelectTest {
	
	@Autowired
	AddrlistBiz biz;

	@Test
	void contextLoads() {
		AddrlistVO obj = null;
		try {
			obj = biz.get(6);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
