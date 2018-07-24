package com.acoda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.acoda.biz.Post_BoardBIZ;
import com.acoda.vo.Post_BoardVO;


@Controller
public class Post_BoardServlet {

	@Autowired
	Post_BoardBIZ post_boardBIZ;
	
	@RequestMapping("/select_post_board.do")
	public String post_board_Select(Model m) {
		List<Post_BoardVO> all = post_boardBIZ.getAllPost_Board();
		m.addAttribute("all",all);
		return "post_board/list_post_board";
	}
	
	@RequestMapping(value="/insert_post_board.do",method=RequestMethod.GET)
	public String post_board_Insert(@ModelAttribute Post_BoardVO vo) {
		int r = post_boardBIZ.getInsertPost_Board(vo);
		return "select_post_board.do";
		
	}
	
	@RequestMapping(value="/insert_page.do")
	 public String insert_page() {
		 return "post_board/input_post_board";
	 }
	
	
	@RequestMapping(value="/find.do", method=RequestMethod.GET)
	public String post_board_find(@RequestParam("find_name") String name,Model m ) {
			Post_BoardVO r= post_boardBIZ.getInsert_Find_Post_Board(name);
			m.addAttribute("find",r);
			return "post_board/input_post_board";
		}
	
	
	
}
