package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.biz.bbs.domain.MenuVO;

@Mapper
public interface MenuDao {
	
	@Select("select * from tbl_menu where menu_p_id is null order by menu_id")
	@Results(value= {
			@Result(property = "menu_id",column = "menu_id"),
			@Result(property = "drop_menus",column = "menu_id",
			javaType=List.class,
			many=@Many(select = "getSubMenu")
			)
	})
	public List<MenuVO> getAllMenu();
	
	@Select("select * from tbl_menu where menu_p_id=#{menu_id}")
	@Results(value= {
			@Result(property = "menu_id",column = "menu_id"),
			@Result(property = "drop_menus2",column = "menu_id",
			javaType=List.class,
			many=@Many(select = "getTest")
			)
	})
	public List<MenuVO> getSubMenu(String menu_id);
	
	@Select("select * from tbl_menu where menu_id=#{menu_id}")
	public List<MenuVO> getTest(String menu_id);
}
