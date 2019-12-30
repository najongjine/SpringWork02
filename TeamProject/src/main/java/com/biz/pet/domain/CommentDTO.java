package com.biz.pet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CommentDTO {

	private long c_seq;			//number
	private String c_contentid;	//varchar2(6 byte)
	private String c_writer;		//nvarchar2(125 char)
	private String c_date;			//nvarchar2(125 char)
	private String c_text;			//nvarchar2(2000 char)

}
