package com.multi.frame;

import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;

public class Util {
	public static void saveFile(MultipartFile mf, String admindir) {
	
		byte [] data;
		String imgname = mf.getOriginalFilename();
		try {
			data = mf.getBytes();
			FileOutputStream fo = 
					new FileOutputStream(admindir+imgname);
			fo.write(data);
			fo.close();
		
		}catch(Exception e) {
			
		}
		
	}
	
}




