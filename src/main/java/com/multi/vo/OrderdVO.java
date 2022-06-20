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
// 결제시 생성되는 주문건
public class OrderdVO {
	private Integer orid; // 주문번호
	private String uid; // 주문자 아이디
	private Date ordate; // 주문일자
	private int totalprice; //총 가격
	private String addr;// 배송지
	private String receivename; // 수령인 이름
	private String status; // 배송상태, 사실 syntax 미정
	private String transaction; // 결제정보, 사실 syntax 미정(2)
	
	// DB 추가용 id(auto_increment),ordate 없는 생성자
	public OrderdVO(String uid, int totalprice, String addr, String receivename, String status,
			String transaction) {
		this.uid = uid;
		this.totalprice = totalprice;
		this.addr = addr;
		this.receivename = receivename;
		this.status = status;
		this.transaction = transaction;
	}

	// 수정용
	public OrderdVO(Integer orid, String uid, int totalprice, String addr, String receivename, String status) {
		this.orid = orid;
		this.uid = uid;
		this.totalprice = totalprice;
		this.addr = addr;
		this.receivename = receivename;
		this.status = status;
	}
}
