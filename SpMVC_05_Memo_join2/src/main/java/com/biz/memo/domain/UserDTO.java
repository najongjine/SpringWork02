package com.biz.memo.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ScriptAssert;

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
@ScriptAssert(lang = "javascript", script="(_this.u_password==_this.re_password)",
reportOn="re_password",message="비밀번화와 확인 비번이 다름!")
public class UserDTO {
	/*
	 * @Email: email 형식 검사
	 * @NotBlank: 공백검사
	 * @Null: null일 경우만 정상
	 * @Max(), @Min()
	 * @Size(min=,max=): 문자열일경우
	 * @DecimalMax(x): x값 이하의 실수
	 * @DecimalMin(x): x값 이상의 실수
	 * @Digits(integer=x): x 자릿수 이하의 정수
	 * @Digits(integer=x,fraction=y): 자릿수 이하의 정수이면서 y자릿수 이하의 소수점
	 */
	@NotBlank
	@Email(message="이메일형식 으로만 써")
	@Size(min=5,max=50)
	private String u_id;
	private String u_password;
	private String re_password;
	private String u_name;
	
	@NotBlank(message = "닉네임은 비어있으면 안되;!")
	private String u_nick;
	private String u_grade;
	
	@Pattern(regexp="\\d{1,15}", message = "1~15까지의 숫자만 가능")
	private String u_tel;
}

