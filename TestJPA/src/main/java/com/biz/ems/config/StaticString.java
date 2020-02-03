package com.biz.ems.config;

public class StaticString {
	public static String string1="create table tbl_test( " + 
			"BBS_ID	BIGINT	AUTO_INCREMENT	PRIMARY KEY, " + 
			"BBS_P_ID	BIGINT	DEFAULT 0	, " + 
			"BBS_WRITER	nVARCHAR(50)	NOT NULL	, " + 
			"BBS_DATE	VARCHAR(10)		, " + 
			"BBS_TIME	VARCHAR(10)		, " + 
			"BBS_SUBJECT	nVARCHAR(125)		, " + 
			"BBS_CONTENT	nVARCHAR(1000)		, " + 
			"BBS_COUNT	INT	DEFAULT 0	 " + 
			")";
	public static String string2="testDB";
}
