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
public class BoardVO {
	private int bid;
	private int pid;
	private String uid;
	private String title;
	private String contents;
	
	
	// 상품별 글 목록 불러올때 bid, uid, pid
	public BoardVO(int bid, int pid, String uid) {
		this.bid = bid;
		this.pid = pid;
		this.uid = uid;
	}

	}
	

