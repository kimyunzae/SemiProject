package com.multi.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartVO {
	private Integer crid;
	private String uid;
	private int pid;
	private int cnt;
	
	
	
	public CartVO(Integer crid, int cnt) {
		this.crid = crid;
		this.cnt = cnt;
	}

//	@Override
//	public String toString() {
//		return "CartVO [crid=" + crid + ", uid=" + uid + ", pid=" + pid + ", cnt=" + cnt + "]";
//	}
	
//	private String catename;
//	private String pname;
	
//	public CartVO(String uid, int pid, int cnt) {
//		this.uid = uid;
//		this.pid = pid;
//		this.cnt = cnt;
//	}
	
	
	
}










