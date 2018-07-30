package com.acoda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

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
		return "post_boardView/list_post_board";
	}
	
		
	@RequestMapping(value="/insert.do",method=RequestMethod.GET)
	public ModelAndView post_board_Insert(@ModelAttribute Post_BoardVO vo) {
		System.out.println("Post_BoardServlet �� post_board_Insert ����");
		int r = post_boardBIZ.getInsert_User_Post_Board(vo);
		InternalResourceView irv = new InternalResourceView("/post_board/select.do");
	return new ModelAndView(irv);
	}
	
	
	@RequestMapping(value="/insert_user_page.do")
	 public ModelAndView post_board_insertpage() {
		InternalResourceView irv = new InternalResourceView("/input/input_post_board.jsp");
		 return new ModelAndView(irv);
	 }
	
	
	@RequestMapping(value="/find.do", method=RequestMethod.GET)
	public String post_board_find(@RequestParam("find_name") String name,Model m ) {
			return null;
		}
	
	@RequestMapping(value="/delete.do", method=RequestMethod.GET)
	public ModelAndView post_board_delete(@RequestParam("del_id") String id) {
		
		int r=post_boardBIZ.getDelPost_Board(id);
		InternalResourceView irv = new InternalResourceView("/post_board/select.do");
		
		if(r>0) {
			return new ModelAndView(irv);
		}else {
			return null;
		}
	}
	
}
