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
public class MemberBCodesManagerVO {
	private String mng_b_code; // PK
	private String mng_member_id; //FK
	
	private BooksVO booksVO;
}
