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
public class ProductVO {
	private Integer pid; // 상품번호
	private String pname; // 상품명
	private int pprice; // 가격
	private Date regdate; // 상품 등록일
	private int cid; // 카테고리 아이디
	private String pimgname; // 상품 이미지
	private String pcontents; // 상품글의 내용
	private String cname; // 카테고리명
	/* private Integer parentcid; // 상위 카테고리 아이디
	 * private String parentcname; // 상위 카테고리명
	 */

	// DB 추가용 id(auto_increment),regdate(curdate()) 없는 생성자
	public ProductVO(String pname, int pprice, int cid, String pimgname, String pcontents) {
		this.pname = pname;
		this.pprice = pprice;
		this.cid = cid;
		this.pimgname = pimgname;
		this.pcontents = pcontents;
	}
	
	// 업데이트용
	public ProductVO(Integer pid, String pname, int pprice, int cid, String pimgname, String pcontents) {
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.cid = cid;
		this.pimgname = pimgname;
		this.pcontents = pcontents;
	}	
}






