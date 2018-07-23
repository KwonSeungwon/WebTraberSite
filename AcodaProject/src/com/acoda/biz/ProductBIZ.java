package com.acoda.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acoda.dao.ProductDAO;

@Service
public class ProductBIZ {
	
	@Autowired
	ProductDAO productDAO;
	

}
