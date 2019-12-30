package com.biz.product.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.product.domain.ProFileDTO;

public interface FileDao {
	public List<ProFileDTO> fileList(List<ProFileDTO> fileList);
	public void filesInsert(@Param("files") List<ProFileDTO> files, @Param("p_code") String p_code);
	public void fileInsert(ProFileDTO file);
	public void filesDelete(List<ProFileDTO> files);
	public void fileDelete(long file_seq);
	//update은 걍 삭제하고 새로 추가하는식
	public ProFileDTO findByFileSeq(String file_seq);
	public int fileDelete(String file_seq);
<<<<<<< HEAD
=======
	public List<ProFileDTO> findByPCode(String p_code);
>>>>>>> 9d05e48e65bbf5f0c3c46ae78ac8c95f660b9168
}
