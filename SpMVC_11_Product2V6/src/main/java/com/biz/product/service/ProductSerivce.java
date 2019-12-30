package com.biz.product.service;

<<<<<<< HEAD
=======
import java.util.Arrays;
>>>>>>> 9d05e48e65bbf5f0c3c46ae78ac8c95f660b9168
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.product.domain.PageDTO;
import com.biz.product.domain.ProFileDTO;
import com.biz.product.domain.ProductDTO;
import com.biz.product.persistence.FileDao;
import com.biz.product.persistence.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductSerivce {
	@Autowired
	SqlSession sqlSession;
	@Autowired
	FileService fService;
	ProductDao proDao;
	
	FileDao fileDao;
	
	@Autowired
	public void newDao() {
		this.proDao = sqlSession.getMapper(ProductDao.class);
		fileDao=sqlSession.getMapper(FileDao.class);
	}
<<<<<<< HEAD
	public long totalCount() {
		return proDao.proTotalCount();
=======
	public long totalCount(String p_name) {
		String[] p_names=p_name.split(" ");
		List<String> p_nameList=Arrays.asList(p_names);
		return proDao.proTotalCount(p_nameList);
	}
	public List<ProductDTO> findByNameAndPagination(String p_name, PageDTO pageDTO) {
		List<String> p_names=Arrays.asList(p_name.split(" "));
		return proDao.findByPNameListAndPagiNation(p_names,pageDTO);
>>>>>>> 9d05e48e65bbf5f0c3c46ae78ac8c95f660b9168
	}
	public List<ProductDTO> selectPagination(PageDTO pageDTO) {
		List<ProductDTO> proDTOList=proDao.selectPagination(pageDTO);
		return proDTOList;
	}
	public ProductDTO findByPCode(String p_code) {
		return proDao.findByPCode(p_code);
	}
	
	public List<ProductDTO> findByPNames(String p_name) {
		return proDao.findByPNames(p_name);
	}


	public List<ProductDTO> selectAll() {
		return proDao.selectAll();
	}


	public int insert(ProductDTO proDTO, List<ProFileDTO> upFileList) {
		// TODO Auto-generated method stub
		String p_code=proDao.getMaxPCode();
		String p_prefixCode="P";
		
		//상품 데이터가 하나도 없을경우 대비
		int intPCode=1;
		try {
			p_prefixCode=p_code.substring(0, 1);
			String p_suffixCode=p_code.substring(1);
			intPCode=Integer.valueOf(p_suffixCode)+1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		p_code=String.format("%s%04d",p_prefixCode, intPCode);
		proDTO.setP_code(p_code);
		/*
		 * 파일 리스트에 상품코드를 등록하여 상품과 파일리스트간에 연관을 설정하기
		 */
		if(upFileList!=null) {
			/*
			 * 동적쿼리를 작성하여 한번의 커넥션으로 다수의 insert를 수행
			 */
			fileDao.filesInsert(upFileList,p_code);
			int nSize=upFileList.size();
			/*
			for(int i=0;i<nSize;i++) {
				upFileList.get(i).setFile_p_code(p_code);
				log.debug("파일정보: "+upFileList.get(i).toString());
				//fileDao.fileInsert(upFileList.get(i));
			}*/
			//fileDao.fileList(upFileList);
			
		}
		int ret=proDao.insert(proDTO);
		return ret;
	}
	public int update(ProductDTO proDTO) {
		return proDao.update(proDTO);
	}

	public int update(ProductDTO proDTO, List<ProFileDTO> upFileList) {
		if(upFileList!=null) {
			String p_code=proDTO.getP_code();
			fileDao.filesInsert(upFileList, p_code);
		}
		
		return proDao.update(proDTO);
	}

	/*
	 * tbl_files에서 file_seq에 해당하는 이미지 파일 정보를 가져오기
	 * 1. 이미지 파일을 삭제하고
	 * 2. 이미지 파일이 삭제가 완료되면 table에서 file정보를 제거
	 */
	public String subImgDelete(String file_seq) {
		// TODO Auto-generated method stub
		ProFileDTO proFileDTO=fileDao.findByFileSeq(file_seq);
		String file_name=proFileDTO.getFile_upload_name();
		String p_code=proFileDTO.getFile_p_code();
		fService.fileDelete(file_name);
		
		//table에서 정보 제거
		fileDao.fileDelete(file_seq);
		
		return p_code;
	}

	//상품코드를 메게변수로 받아서 대표이미지와 이미지 정보를 제거
	public void proImgDelete(String p_code) {
		// TODO Auto-generated method stub
		ProductDTO proDTO=proDao.findByPCode(p_code);
		if(proDTO.getP_file()!=null && !proDTO.getP_file().isEmpty()) {
			fService.fileDelete(proDTO.getP_file());
			proDTO.setP_file(null);
			proDao.update(proDTO);
		}
		
	}
<<<<<<< HEAD
=======
	
>>>>>>> 9d05e48e65bbf5f0c3c46ae78ac8c95f660b9168


}
