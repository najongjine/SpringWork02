package com.biz.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.product.domain.ProductDTO;
import com.biz.product.persistence.ProductDao;

@Service
public class ProductSerivce {
	
	@Autowired
	SqlSession sqlSession;
	
	ProductDao proDao;
	
	@Autowired
	public void proDao() {
		this.proDao = sqlSession.getMapper(ProductDao.class);
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


	public int insert(ProductDTO proDTO) {
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
		return proDao.insert(proDTO);
	}


	public int update(ProductDTO proDTO) {
		// TODO Auto-generated method stub
		return proDao.update(proDTO);
	}

	
}
