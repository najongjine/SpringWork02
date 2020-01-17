package com.biz.rbooks.respository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.rbooks.domain.BookVO;

public interface BookDao {
	@Select("select * from tbl_books")
	public List<BookVO> selectAll();

}
