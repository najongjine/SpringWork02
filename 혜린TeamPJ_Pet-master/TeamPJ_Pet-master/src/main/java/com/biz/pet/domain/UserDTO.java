package com.biz.pet.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

	@NotNull
	@NotBlank(message = "id는 공백일 수 없습니다")
	@Email(message = "이메일 형식으로만 써주세요")
	@Size(min = 5, max = 100)
	private String u_id;		//varchar2(125 byte)   유저 아이디
	private String u_name;		//nvarchar2(125 char)  유저 이름
	private String u_password;	//nvarchar2(125 char)  유저 비밀번호
	
	@NotBlank(message = "반려동물 이름은 반드시 입력하셔야합니다")
	private String u_pname;	//nvarchar2(125 char) 	   반려동물 이름
	private String u_page;		//varchar2(125 byte)   반려동물 나이
	private String u_pweight;	//varchar2(125 byte)   반려동물 무게
	
}
