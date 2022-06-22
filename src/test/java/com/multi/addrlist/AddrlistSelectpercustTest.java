package com.multi.addrlist;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AddrlistBiz;
import com.multi.vo.AddrlistVO;

@SpringBootTest
class AddrlistSelectpercustTest {

	@Autowired
	AddrlistBiz biz;

	@Test
	void contextLoads() {
		List<AddrlistVO> l = null;
		try {
			l = biz.getpercust("id03");
			for (AddrlistVO obj : l) {				
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
