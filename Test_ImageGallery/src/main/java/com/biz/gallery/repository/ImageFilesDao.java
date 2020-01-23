package com.biz.gallery.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.biz.gallery.domain.ImageFilesVO;

public interface ImageFilesDao {
	@Select("select * from tbl_images")
	public List<ImageFilesVO> selectAll();
	
	@Select("select * from tbl_images where IMG_FILE_SEQ=#{img_file_seq}")
	public ImageFilesVO findBySeq(long img_file_seq);
	
	public List<ImageFilesVO> findByPCode(long img_p_code);
	
	@Delete("delete from tbl_images where IMG_FILE_P_CODE=#{img_seq} order by img_file_seq ascending")
	public int delete(long img_seq);
	
	@InsertProvider(type=ImageFileSQL.class,method="insert_sql")
	public int insert(ImageFilesVO file);
	
	@Insert(ImageFileSQL.bulk_insert_sql)
	public int bulk_insert(@Param("files") List<ImageFilesVO> files, @Param("img_p_code") long p_code);

	@Delete("delete from tbl_images where img_file_seq=#{img_file_seq}")
	public int deleteBySeq(long img_file_seq);
}
