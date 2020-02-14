package com.biz.rbooks.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
/*
 * tbl_member_bcodes_manger
 * 
 * 멀티유저를 구현하기 위해 추가로 만든 테이블
 * 
 * 이론:=
 * 
 * 여러 유저들이 존재한다 == tbl_member (1)
 * 한 유저(tbl_member (1) )는 
 * 여러 책을 읽을수 있다 == tbl_member_bcodes_manager (N)
 * FK는 m_id가 된다
 * 
 * 한 종류의 책(예: 드래곤볼) 은 여러종류의 책일수 없다
 * (예: 드래곤볼 읽었던 사람들끼리 모였는데 어느 사람이 나루토 이야기 할수는 없음)
 * 그래서 책 코드에 PK를 걸어버린다
 * 
 */
public class MemberBCodesManagerVO {
	private String mng_b_code; // PK
	private String mng_member_id; //FK
	
	//약한 연관관계를 위해서 tbl_books의 정보를 가질수 있게 하였다.
	//tbl_books와는 제약조건을 설정하지 않았다.
	//강한 연관관계로 constraint를 설정해 버리면 
	//tbl_manager 데이터를 지울시, 책까지 날라가버리는 사고가 발생하기 때문이다.
	private BooksVO booksVO;
}
