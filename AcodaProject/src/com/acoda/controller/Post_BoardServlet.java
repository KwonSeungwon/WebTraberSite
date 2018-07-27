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
	
	@RequestMapping("/select_hugi.do")
	public String post_board_Select_hugi(Model m) {
		List<Post_BoardVO> all = post_boardBIZ.getHugiPost_Board();
		m.addAttribute("all",all);
		return "post_boardView/hugi_post_board";
	}
	
	@RequestMapping("/select_user.do")
	public String post_board_Select_user(Model m) {
		List<Post_BoardVO> all = post_boardBIZ.getUserPost_Board();
		m.addAttribute("all",all);
		return "post_boardView/user_post_board";
	}
	
	@RequestMapping(value="/click.do", method=RequestMethod.GET)
	public String post_board_click(@RequestParam("click_post_number") String click_post_number,Model m ) {
			List<Post_BoardVO> vo = post_boardBIZ.getClickPost_Board(click_post_number);
			m.addAttribute("click",vo);
			
			return "post_boardView/click_post_board";
		}
	
	
	@RequestMapping(value="/insert_user.do",method=RequestMethod.GET)
	public ModelAndView post_board_Insert_user(@ModelAttribute Post_BoardVO vo) {
		
		int r = post_boardBIZ.getInsert_User_Post_Board(vo);
		InternalResourceView irv = new InternalResourceView("/post_board/select_user.do");
		return new ModelAndView(irv);
	}
	
	
	@RequestMapping(value="/insert_user_page.do")
	 public ModelAndView post_board_insertpage_user() {
		InternalResourceView irv = new InternalResourceView("/input/input_post_board_user.jsp");
		 return new ModelAndView(irv);
	 }
	
	@RequestMapping(value="/insert_hugi.do",method=RequestMethod.GET)
	public ModelAndView post_board_Insert_hugi(@ModelAttribute Post_BoardVO vo) {
		
		int r = post_boardBIZ.getInsert_Hugi_Post_Board(vo);
		InternalResourceView irv = new InternalResourceView("/post_board/select_hugi.do");
		return new ModelAndView(irv);
	}
	
	
	@RequestMapping(value="/insert_hugi_page.do")
	 public ModelAndView post_board_insertpage_hugi() {
		InternalResourceView irv = new InternalResourceView("/input/input_post_board_hugi.jsp");
		 return new ModelAndView(irv);
	 }
	
	
	@RequestMapping(value="/find_user.do", method=RequestMethod.GET)
	public ModelAndView post_board_find_user(@RequestParam("find_post_number") String find_post_number,Model m ) {
			Post_BoardVO vo = post_boardBIZ.getFindPost_Board(find_post_number);
			m.addAttribute("find",vo);
			InternalResourceView irv = new InternalResourceView("/input/update_post_board_user.jsp");
			return new ModelAndView(irv);
		}
	
	@RequestMapping(value="/find_hugi.do", method=RequestMethod.GET)
	public ModelAndView post_board_find_hugi(@RequestParam("find_post_number") String find_post_number,Model m ) {
			Post_BoardVO vo = post_boardBIZ.getFindPost_Board(find_post_number);
			m.addAttribute("find",vo);
			InternalResourceView irv = new InternalResourceView("/input/update_post_board_hugi.jsp");
			return new ModelAndView(irv);
		}
	
	@RequestMapping(value="/delete_user.do", method=RequestMethod.GET)
	public ModelAndView post_board_delete_user(@RequestParam("del_post_number") String post_number) {
		
		int r=post_boardBIZ.getDelPost_Board(post_number);
		InternalResourceView irv = new InternalResourceView("/post_board/select_user.do");
		
		if(r>0) {
			return new ModelAndView(irv);
		}else {
			return null;
		}
	}
	
	@RequestMapping(value="/delete_hugi.do", method=RequestMethod.GET)
	public ModelAndView post_board_delete_hugi(@RequestParam("del_post_number") String del_post_number) {
		
		int r=post_boardBIZ.getDelPost_Board(del_post_number);
		InternalResourceView irv = new InternalResourceView("/post_board/select_hugi.do");
		
		if(r>0) {
			return new ModelAndView(irv);
		}else {
			return null;
		}
	}
	
	@RequestMapping(value="/update_user.do",method=RequestMethod.GET)
	public ModelAndView my_update(@ModelAttribute("postboardvo") Post_BoardVO vo) {
		int r =post_boardBIZ.getUpdate_User_Post_Board(vo);
		InternalResourceView irv = new InternalResourceView("/post_board/select_user.do");
		return new ModelAndView(irv);
	}
	
	
	
}
