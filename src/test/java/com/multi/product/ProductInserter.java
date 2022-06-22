package com.multi.product;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.ProductBiz;
import com.multi.vo.ProductVO;

@SpringBootTest
class ProductInserter {

	@Autowired
	ProductBiz biz;

	@Value("${admindir}")
	String admindir;
	@Value("${userdir}")
	String userdir;

	@Test
	void contextLoads() {
		String path = "C:\\Users\\misak\\Downloads\\loading.png";
		ProductVO obj = new ProductVO("blend1", 10000, 20, "", "");
		upload(path,obj);
	}
	
	public void upload(String path, ProductVO vo) {
		File uploadingImage = new File(path);
		String imgname = uploadingImage.getName();
		try {
			Files.copy(uploadingImage.toPath(), new File(admindir + "/assets/img/espresso/" + imgname).toPath());
			//Files.copy(uploadingImage.toPath(), new File(userdir + "/assets/img/espresso/" + imgname).toPath());
			ProductVO obj = vo;
			obj.setPimgname(imgname);
			System.out.println("Registered OK");
			System.out.println(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
