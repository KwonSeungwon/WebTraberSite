package com.acoda.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.acoda.biz.FestivalBIZ;
import com.acoda.vo.FestivalVO;

@Controller
@RequestMapping("/festival")
public class FestivalServlet {
	
	@Autowired
	FestivalBIZ festivalBIZ;
	
	@RequestMapping("/select.do")
	public String f_Select(Model m) {
		List<FestivalVO> all = festivalBIZ.getAllFestival();
		
		m.addAttribute("all",all);
		return "festival/list_festival";
		
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
