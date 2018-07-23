package com.acoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.acoda.biz.ProductBIZ;

@Controller
public class ProductServlet {
	
	@Autowired
	ProductBIZ productBIZ;

}
