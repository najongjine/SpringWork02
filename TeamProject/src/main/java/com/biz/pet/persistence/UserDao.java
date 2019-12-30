package com.biz.pet.persistence;

import com.biz.pet.domain.UserDTO;

public interface UserDao {

	public int userInsert(UserDTO userDTO);

	public UserDTO findById(String u_id);

}
