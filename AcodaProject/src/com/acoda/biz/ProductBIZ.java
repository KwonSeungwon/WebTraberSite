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
	//검색
	public List<ProductVO> getSearch_product(String name){
		System.out.println("상품검색 비즈"+productDAO.getSearch_product(name).size());
		return productDAO.getSearch_product(name);
	}
	//클릭
	public List<ProductVO> getClickProduct(int number){
		return productDAO.getClickProduct(number);
	}
	
	public ProductVO getFindProduct(String name) {
		return null;
		
	}
	//삭제
	public int getDelProduct(String del_name) {
		
		return productDAO.getDelProduct(del_name);
		
	}
	
	public int getUpdateProduct(ProductVO vo) {
		return productDAO.getUpdateProduct(vo);
	}

	public ProductVO getDetail(int item_num) {

		return productDAO.getDetailinfo(item_num);
	}


	public ProductVO getproductupdateinfo(int num) {
		return productDAO.getupdateinfo(num);
	}

}
