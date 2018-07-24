package com.acoda.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acoda.dao.ProductDAO;
import com.acoda.vo.ProductVO;


@Service
public class ProductBIZ {
	
	@Autowired
	ProductDAO productDAO;
	
	public List<ProductVO> getAllProduct(){
		return null;
		
	}
	
	public int getInsertProduct(ProductVO vo) {
		return 0;
		
	}
	
	public ProductVO getFindProduct(String name) {
		return null;
		
	}
	
	public int getDelProduct(String del_name) {
		return 0;
		
	}
	
	public int getUpdateProduct(ProductVO vo) {
		return 0;
	}

}
