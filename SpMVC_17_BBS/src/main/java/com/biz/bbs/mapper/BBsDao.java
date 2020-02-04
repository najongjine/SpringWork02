package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.bbs.domain.BBsVO;

public interface BBsDao {
	@Select("select * from tbl_bbs order by bbs_date desc, bbs_time desc")
	public List<BBsVO> selectAll();
	
	public List<BBsVO> selectMain();

	public void update(BBsVO bbsVO);

	public void insert(BBsVO bbsVO);

	@Select("select * from tbl_bbs where bbs_id=#{bbs_id}")
	public BBsVO findById(long bbs_id);
}
