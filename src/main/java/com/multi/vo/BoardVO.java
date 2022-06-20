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
public class BoardVO {
	private int bid;
	private int pid;
	private String uid;
	private String title;
	private String contents;
	
	public BoardVO(int bid, String title, String contents) {
		this.bid = bid;
		this.title = title;
		this.contents = contents;
	}
	
	
	
}
