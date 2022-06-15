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
	private int id;
	private String uid;
	private int pid;
	private int cnt;
	private Date regdate;
	public CartVO(int id, String uid, int pid, int cnt) {
		super();
		this.id = id;
		this.uid = uid;
		this.pid = pid;
		this.cnt = cnt;
	}
	
	
	//private String pname;
	//private int pprice;
	//private String catename;
	
}










