package com.multi.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CateVO {
	private int cid;
	private String cname;
	private Integer parentcid;
	
	public CateVO(int cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}


}


