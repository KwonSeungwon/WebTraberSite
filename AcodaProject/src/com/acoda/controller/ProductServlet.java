package com.acoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.acoda.biz.ProductBIZ;
import com.acoda.vo.ProductVO;

@Controller
public class ProductServlet {
	
	@Autowired
	ProductBIZ productBIZ;

	public String Product_Select(Model m) {
		return null;
		
	}
	
	public String Product_Insert(ProductVO vo) {
		return null;
		
	}
	
	public String Product_insertpage() {
		return null;
		
	}
	
	public String Product_find() {
		return null;
	}
	
	public String Product_delete() {
		return null;
	}
	
	public String Product_update() {
		return null;
	}
}
