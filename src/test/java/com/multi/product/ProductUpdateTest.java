package com.multi.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.biz.ProductBiz;
import com.multi.vo.CustVO;
import com.multi.vo.ProductVO;

@SpringBootTest
class ProductUpdateTest {
	
	@Autowired
	ProductBiz biz;

	@Test
	void contextLoads() {
<<<<<<< HEAD
		ProductVO obj = new ProductVO(null,"old Espresso",200,null,"","Espresso");
=======
		ProductVO obj = new ProductVO(1003,"blend1",10000,21,"","블렌드");
>>>>>>> a74c6008404c6d412951bd1880e036eb05418181
		try {
			biz.modify(obj);
			System.out.println("Update OK");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
