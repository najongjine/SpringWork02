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
public class FriendVO {
	private long f_id;// bigint primary key auto_increment,
	private String f_name;// varchar(50),
	private String f_phone;// varchar(20),
	private String f_address;// varchar(255),
	private String f_relation;// varchar(50)
}
