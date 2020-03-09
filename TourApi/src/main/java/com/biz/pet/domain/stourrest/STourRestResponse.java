package com.biz.pet.domain.stourrest;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement(name="response")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class STourRestResponse {
	private STourRestBody body;

	/*
	 * @Override public String toString() { return "STourRestResponse [body=" + body
	 * + "]"; }
	 */
	
}
