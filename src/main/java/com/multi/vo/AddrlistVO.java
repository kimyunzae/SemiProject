package com.multi.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddrlistVO {
	private int aid;
	private String uid;
	private String addr;
	private String receivename;
	
	public AddrlistVO(int aid, String addr, String receivename) {
		this.aid = aid;
		this.addr = addr;
		this.receivename = receivename;
	}
	
}
