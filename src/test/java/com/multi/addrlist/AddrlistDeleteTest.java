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
class AddrlistDeleteTest {
	
	@Autowired
	AddrlistBiz biz;

	@Test
	void contextLoads() {
		try {
			biz.remove(5);
			System.out.println("Delete OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
