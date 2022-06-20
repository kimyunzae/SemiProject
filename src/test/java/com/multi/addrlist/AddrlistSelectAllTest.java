package com.multi.addrlist;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AddrlistBiz;
import com.multi.vo.AddrlistVO;

@SpringBootTest
class AddrlistSelectAllTest {
	
	@Autowired
	AddrlistBiz biz;
	
	@Test
	void contextLoads() {
		List<AddrlistVO> list = null;
		try {
			list = biz.get();
			for (AddrlistVO obj : list) {
				System.out.print("SelectAll OK");
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


