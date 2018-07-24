package com.acoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.acoda.biz.BuyBIZ;
import com.acoda.vo.BuyVO;

@Controller
public class BuyServlet {

	@Autowired
	BuyBIZ buyBIZ;
	
	public String Buy_Select(Model m) {
		return null;
		
	}
	
	public String Buy_Insert(BuyVO vo) {
		return null;
		
	}
	
	public String Buy_insertpage() {
		return null;
		
	}
	
	public String Buy_find() {
		return null;
	}
	
	public String Buy_delete() {
		return null;
	}
	
	public String Buy_update() {
		return null;
	}
}
