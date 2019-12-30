package com.biz.memo.persistence;

import org.apache.ibatis.annotations.Param;

import com.biz.memo.domain.UserDTO;

public interface UserDao {

	public int userInsert(UserDTO userDTO);
	public int userCount();
	public UserDTO findById(@Param("u_id") String u_id);

}
