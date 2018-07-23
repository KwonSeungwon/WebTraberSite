package com.acoda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.acoda.vo.ProductVO;


@Repository
public class ProductDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ProductVO> getAllProduct(){
		return null;
		
	}
	
	public int getDelProduct(String del_name) {
		return 0;
		
	}
	
	public int getInsertProduct(ProductVO vo) {
		return 0;
		
	}
	
	public ProductVO getFindProduct(String find_product) {
		return null;
		
	}
	
	public int getUpdateProduct(ProductVO vo) {
		return 0;
		
	}

}
