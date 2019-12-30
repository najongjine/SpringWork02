package com.biz.memo.domain;

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
public class HobbyDTO {
	private String h_code	;//VARCHAR(5)
	private String h_name	;//nVARCHAR(125)
	private String h_rem	;//nVARCHAR(125)
}
