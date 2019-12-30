package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.domain.ProductDTO;
import com.biz.iolist.persistence.ProductDao;

@Service
public class ProductService {
	@Autowired
	SqlSession sqlSession;
	
	public List<ProductDTO> getAllList(){
		ProductDao prodDao=sqlSession.getMapper(ProductDao.class);
		List<ProductDTO> prodList=prodDao.selectAll();
		return prodList;
	}

	public int insert(ProductDTO prodDTO) {
		// TODO Auto-generated method stub
		ProductDao prodDao=sqlSession.getMapper(ProductDao.class);
		String maxPCode=prodDao.getPCode();
		int intPCode=Integer.valueOf(maxPCode.substring(1));
		intPCode++;
		maxPCode=maxPCode.substring(0, 1);
		maxPCode+=String.format("%04d", intPCode);
		prodDTO.setP_code(maxPCode);
		int ret=prodDao.insert(prodDTO);
		return 0;
	}

	public ProductDTO findByDCode(String p_code) {
		ProductDao prodDao=sqlSession.getMapper(ProductDao.class);
		ProductDTO dDTO=prodDao.findByDCode(p_code);
		return dDTO;
	}

	public int delete(String p_code) {
		ProductDao prodDao=sqlSession.getMapper(ProductDao.class);
		prodDao.delete(p_code);
		return 0;
	}

	public int update(ProductDTO prodDTO) {
		// TODO Auto-generated method stub
		ProductDao prodDao=sqlSession.getMapper(ProductDao.class);
		int ret=prodDao.update(prodDTO);
		return ret;
	}
}
