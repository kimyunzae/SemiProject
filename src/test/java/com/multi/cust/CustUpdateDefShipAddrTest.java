//package com.multi.cust;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.multi.biz.CustBiz;
//import com.multi.vo.CustVO;
//
//@SpringBootTest
//class CustUpdateDefShipAddrTest {
//	
//	@Autowired
//	CustBiz biz;
//
//	@Test
//	void contextLoads() {
//		CustVO obj = new CustVO("id01",8);
//		try {
//			biz.modifyDefShipAddr(obj);
//			System.out.println("Update OK");
//			System.out.println(obj);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
