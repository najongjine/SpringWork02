package com.biz.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	ProductDao proDao;
	
	FileDao fileDao;
	
	@Autowired
	public void newDao() {
		this.proDao = sqlSession.getMapper(ProductDao.class);
		fileDao=sqlSession.getMapper(FileDao.class);
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
		String p_code=proDTO.getP_code();
		fileDao.filesInsert(upFileList, p_code);
		return proDao.update(proDTO);
	}

	
}
