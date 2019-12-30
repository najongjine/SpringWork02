package com.biz.iolist.service;

import java.util.ArrayList;
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
	
	ProductDao pDao;
	
	@Autowired
	public void getProMapper() {
		pDao=sqlSession.getMapper(ProductDao.class);
	}
	
	public List<ProductDTO> getAllList(){
		List<ProductDTO> prodList=pDao.selectAll();
		return prodList;
	}

	public int insert(ProductDTO prodDTO) {
		// TODO Auto-generated method stub
		String maxPCode=pDao.getPCode();
		int intPCode=Integer.valueOf(maxPCode.substring(1));
		intPCode++;
		maxPCode=maxPCode.substring(0, 1);
		maxPCode+=String.format("%04d", intPCode);
		prodDTO.setP_code(maxPCode);
		int ret=pDao.insert(prodDTO);
		return 0;
	}

	public ProductDTO findByPCode(String p_code) {
		ProductDTO dDTO=pDao.findByPCode(p_code);
		return dDTO;
	}

	public int delete(String p_code) {
		pDao.delete(p_code);
		return 0;
	}

	public int update(ProductDTO prodDTO) {
		// TODO Auto-generated method stub
		int ret=pDao.update(prodDTO);
		return ret;
	}

	public List<ProductDTO> selectNameSearch(String strText) {
		List<ProductDTO> proList=null;
		ProductDTO pDTO=pDao.findByPCode(strText);
		if(pDTO!=null) {
			proList=new ArrayList<ProductDTO>();
			proList.add(pDTO);
		}else {
			proList=pDao.findByName(strText);
		}
		return proList;
	}
}
