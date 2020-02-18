package com.biz.crawl.domain;

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
public class NaverMovieVO {
	private long id;// bigint primary key auto_increment,
	private int m_rank;// int unique,
	private String m_title;// varchar(125),
	private String m_detail_url;// varchar(255),
	private String m_image_url;// varchar(255)
}
