package com.multi.addrlist;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AddrlistBiz;
import com.multi.vo.AddrlistVO;

@SpringBootTest
class iwillgetarrayofaid {

	@Autowired
	AddrlistBiz biz;

	@Test
	void contextLoads() {
		List<AddrlistVO> l = null;
		ArrayList<Integer> aids = new ArrayList<Integer>();
		try {
			l = biz.getpercust("id03");
			for (AddrlistVO obj : l) {				
				aids.add(obj.getAid());
			}
			for (int j : aids) {
				System.out.println(j);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
