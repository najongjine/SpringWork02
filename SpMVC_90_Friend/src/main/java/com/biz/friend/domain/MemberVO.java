package com.biz.friend.domain;

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
public class MemberVO {
	private long m_id;// bigint primary key auto_increment,
	private String m_username;// varchar(50) unique not null,
	private String m_password;// varchar(50) not null
}
