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
@RequestMapping("/post_board")
public class Post_BoardServlet {

	@Autowired
	Post_BoardBIZ post_boardBIZ;
	
	@RequestMapping("/select.do")
	public String post_board_Select(Model m) {
		List<Post_BoardVO> all = post_boardBIZ.getAllPost_Board();
		m.addAttribute("all",all);
		return "post_board/list_post_board";
	}
	
	@RequestMapping(value="/insert.do",method=RequestMethod.GET)
	public String post_board_Insert(@ModelAttribute Post_BoardVO vo) {
		System.out.println("Post_BoardServlet ÀÇ post_board_Insert ½ÇÇà");
		int r = post_boardBIZ.getInsertPost_Board(vo);
		return "/AcodaProject/post_board/select.do";
	}
	
	
	@RequestMapping(value="/insert_page.do")
	 public String post_board_insertpage() {
		 return "post_board/input_post_board";
	 }
	
	
	@RequestMapping(value="/find.do", method=RequestMethod.GET)
	public String post_board_find(@RequestParam("find_name") String name,Model m ) {
			return null;
		}
	
	
}
