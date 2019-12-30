package com.biz.product.persistence;

import java.util.List;

<<<<<<< HEAD
=======
import org.apache.ibatis.annotations.Param;

>>>>>>> 9d05e48e65bbf5f0c3c46ae78ac8c95f660b9168
import com.biz.product.domain.PageDTO;
import com.biz.product.domain.ProductDTO;

public interface ProductDao {

	public List<ProductDTO> selectAll();
	
	//off~limit 까지의 데이터만 추출
	public List<ProductDTO> selectPagination(PageDTO pageDTO);
	public ProductDTO findByPCode(String p_code);
	
	public List<ProductDTO> findByPNames(String p_name);
	public String getMaxPCode();
	
	public int insert(ProductDTO proDTO);
	public int update(ProductDTO proDTO);
	public int delete(String p_code);

<<<<<<< HEAD
	public long proTotalCount();
=======
	public long proTotalCount(@Param("p_names") List<String> p_nameList);

	public List<ProductDTO> findByPNameListAndPagiNation(@Param("p_names") List<String> p_names,@Param("pageDTO") PageDTO pageDTO);
>>>>>>> 9d05e48e65bbf5f0c3c46ae78ac8c95f660b9168
	
}
