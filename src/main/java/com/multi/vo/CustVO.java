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
}



