package com.biz.pet.domain.stourrest;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.ToString;

@XmlRootElement(name="response")
@ToString
public class STourRestResponse {
	public STourRestBody body;

	/*
	 * @Override public String toString() { return "STourRestResponse [body=" + body
	 * + "]"; }
	 */
	
}
