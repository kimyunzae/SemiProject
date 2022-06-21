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
public class CustVO {

	private String uid; // 이용자 아이디
	private String name; // 이름
	private String addr; // 주소
	private String pwd; // 비밀번호
	private String email; // 이메일
	private String phone; // 폰번호
	private Integer def_ship_addr; // addrlist의 aid를 가리킴, 0일 경우 cust를 찾게 해야 함
	
	public CustVO(String uid, int def_ship_addr) {
		this.uid = uid;
		this.def_ship_addr = def_ship_addr;
	}
}



