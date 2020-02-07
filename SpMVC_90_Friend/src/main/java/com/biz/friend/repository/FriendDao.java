package com.biz.friend.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.biz.friend.domain.FriendVO;

public interface FriendDao {
	@Select("select * from tbl_friend LIMIT #{limit} offset #{offset}")
	public List<FriendVO> selectAll(@Param("limit") int limit
			,@Param("offset") int offset);
	
	@Select("select * from tbl_friend where f_name like concat('%',#{f_name},'%') "
			+ " LIMIT #{limit} offset #{offset} ")
	public List<FriendVO> findByf_name(@Param("f_name") String f_name,@Param("limit") int limit
			,@Param("offset") int offset);
	
	@Select("select count(*) from tbl_friend where f_name like concat('%',#{f_name},'%') ")
	public int countFindByf_name(String f_name);
	
	@Select("select count(*) from tbl_friend")
	public int countAll();
	
	public int insert(FriendVO friendVO);
	public int update(FriendVO friendVO);
	
	@Delete("delete from tbl_friend where f_id=#{f_id}")
	public int delete(long f_id);

	@Select("select * from tbl_friend where f_id=#{f_id}")
	public FriendVO findByID(long f_id);
}
