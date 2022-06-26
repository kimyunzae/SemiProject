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
	private Integer pprice;
	private String pimgname;
	private String pname;

// crid의 수량만 변경	
	public CartVO(Integer crid, int cnt) {
		this.crid = crid;
		this.cnt = cnt;
	}

	public CartVO(Integer crid, String uid, int cnt, Integer pprice, String pimgname, String pname) {
		this.crid = crid;
		this.uid = uid;
		this.cnt = cnt;
		this.pprice = pprice;
		this.pimgname = pimgname;
		this.pname = pname;
	}

	public CartVO(Integer crid, String uid, int pid, int cnt) {
		super();
		this.crid = crid;
		this.uid = uid;
		this.pid = pid;
		this.cnt = cnt;
	}
}
