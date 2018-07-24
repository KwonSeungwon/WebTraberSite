package com.acoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.acoda.biz.FestivalBIZ;
import com.acoda.vo.FestivalVO;

@Controller
public class FestivalServlet {
	
	@Autowired
	FestivalBIZ festivalBIZ;
	
	public String Festival_Select(Model m) {
		return null;
		
	}
	
	public String Festival_Insert(FestivalVO vo) {
		return null;
		
	}
	
	public String Festival_insertpage() {
		return null;
		
	}
	
	public String Festival_find() {
		return null;
	}
	
	public String Festival_delete() {
		return null;
	}
	
	public String Festival_update() {
		return null;
	}

	
	
}
