package com.multi.cust;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@SpringBootTest
class CustSelectAllTest {

	@Autowired
	CustBiz biz;

	@Test
	void contextLoads() {
		List<CustVO> list = null;
		try {
			list = biz.get();
			System.out.println("SelectAll OK");
			for (CustVO obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
