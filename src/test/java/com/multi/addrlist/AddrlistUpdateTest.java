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
class AddrlistUpdateTest {
	
	@Autowired
	AddrlistBiz biz;

	@Test
	void contextLoads() {
		AddrlistVO obj = new AddrlistVO(8,"백상금","덴버","백상동");
		try {
			biz.register(obj);
			System.out.println("UPDATE OK");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
