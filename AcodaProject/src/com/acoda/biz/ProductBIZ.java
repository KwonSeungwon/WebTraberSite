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
		return productDAO.getAllProduct();
		
	}
	
	public int getInsertProduct(ProductVO vo) {
		System.out.println("상품 추가 비즈");
		return productDAO.getInsertProduct(vo);
		
	}
	
	public ProductVO getFindProduct(String name) {
		return null;
		
	}
	//삭제
	public int getDelProduct(String del_name) {
		
		return productDAO.getDelProduct(del_name);
		
	}
	
	public int getUpdateProduct(ProductVO vo) {
		return 0;
	}

	public ProductVO getDetail(int item_num) {

		return productDAO.getDetailinfo(item_num);
	}

}
