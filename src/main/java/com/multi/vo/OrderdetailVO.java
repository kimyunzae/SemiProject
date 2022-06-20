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
// 주문의 상품별 개별 내역 
public class OrderdetailVO {
	private Integer odid; // 상품별 주문 아이디
	private int orid; // orderd의 주문 아이디
	private int pid; // 상품번호. 현재 상품을 가리키게 되므로 현재 상품 링크에만 사용되게 된다
	private int price; // 상품 가격. 주문시 당시 가격을 복사함
	private String pname; // 상품명. 주문시 당시 상품명을 복사함
	private int cnt; // 주문상품 갯수
	
	// DB 추가용 id(auto_increment) 없는 생성자
	public OrderdetailVO(int orid, int pid, int price, String pname, int cnt) {
		this.orid = orid;
		this.pid = pid;
		this.price = price;
		this.pname = pname;
		this.cnt = cnt;
	}
}
