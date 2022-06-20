package com.multi.vo;

import java.util.Date;

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
	
	private String catename;
	private String pname;
	
	public CartVO(String uid, int pid, int cnt) {
		this.uid = uid;
		this.pid = pid;
		this.cnt = cnt;
	}
	
	
}










