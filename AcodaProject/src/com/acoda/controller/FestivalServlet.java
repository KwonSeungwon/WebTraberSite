package com.acoda.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping("/insert_fe.do")
	public ModelAndView Festival_Insert(@ModelAttribute FestivalVO vo) {
		ModelAndView mav;
		System.out.println("여기컨트롤러에는 오는가?");
	int f=festivalBIZ.getInsertFestival(vo);
	if(f > 0) {
		mav = new ModelAndView("/festival/list_festival");
	}else {
		mav = new ModelAndView();
	}
	
		return mav;
	}
	
	@RequestMapping("/insert_page.do")
	public String Festival_insertpage() {
		System.out.println("여기서 넘어가는건가?");
		return "festival/insert_festival";
	}
	
	public String Festival_find() {
		return null;
	}
	@RequestMapping("/delete")
	public String Festival_delete(@RequestParam("del_name") String name) {
		System.out.println("여긴 컨트롤러 딜리트");
		   int r=festivalBIZ.getDelFestival(name);
		      if(r>0) {
		         return "/select_festival.do";
		      }else {
		         return "";
		      }
		   
	}
	
	public String Festival_update() {
		return null;
	}

	
	
}
