package com.acoda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.acoda.biz.ReplyBIZ;
import com.acoda.vo.Post_BoardVO;
import com.acoda.vo.ReplyVO;



@Controller
@RequestMapping("/post_board")
public class Post_BoardServlet extends HttpServlet {

	@Autowired
	Post_BoardBIZ post_boardBIZ;
	
	@Autowired
	ReplyBIZ replyBIZ;
	
	//Select(전체목록출력)
	@RequestMapping("/select_hugi.do")
	public String post_board_Select_hugi(Model m) {
		List<Post_BoardVO> all = post_boardBIZ.getHugiPost_Board();
		m.addAttribute("all",all);
		return "post_boardView/hugi_post_board";
	}
	@RequestMapping("/select_user.do")
	public String post_board_Select_user(Model m) throws Exception {
		List<Post_BoardVO> all = post_boardBIZ.getUserPost_Board();
		m.addAttribute("all",all);
		return "post_boardView/user_post_board";
	}
	
	//Insert
	@RequestMapping(value="/insert_user.do",method=RequestMethod.POST)
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
	@RequestMapping(value="/insert_hugi.do",method=RequestMethod.POST)
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
	
	//Find
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
	
	//Update
	@RequestMapping(value="/update_user.do",method=RequestMethod.POST)
	public ModelAndView post_board_update_user(@ModelAttribute("postboardvo") Post_BoardVO vo) {
		int r =post_boardBIZ.getUpdate_User_Post_Board(vo);
		InternalResourceView irv = new InternalResourceView("/post_board/select_user.do");
		return new ModelAndView(irv);
	}
	@RequestMapping(value="/update_hugi.do",method=RequestMethod.POST)
	public ModelAndView post_board_update_hugi(@ModelAttribute("postboardvo") Post_BoardVO vo) {
		int r =post_boardBIZ.getUpdate_Hugi_Post_Board(vo);
		InternalResourceView irv = new InternalResourceView("/post_board/select_hugi.do");
		return new ModelAndView(irv);
	}
	
	//Delete
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
	
	
	//Click(페이지 상세보기)
	@RequestMapping(value="/click.do", method=RequestMethod.GET)
	public String post_board_click(@RequestParam("click_post_number") String click_post_number,Model m ) {
			List<Post_BoardVO> pvo = post_boardBIZ.getClickPost_Board(click_post_number);
			List<ReplyVO> rvo = replyBIZ.getAllReply(click_post_number);
			m.addAttribute("click",pvo);
			m.addAttribute("replyall",rvo);
			return "post_boardView/click_post_board";
	}
	
	//Search(제목으로검색)
	@RequestMapping(value="/search_user.do",method=RequestMethod.GET)
	 public String post_board_search_user(@RequestParam ("search_post_board_user") String s,Model m,HttpSession session) {
			System.out.println("Post_BoardServlet->search_post_board_user(입력받은 검색어) = "+s);
			session.setAttribute("searchKeyword", s);
			//세션 삭제는 session removeattribute("세션이름") or invalidate(); <- 모든 세션삭제  - 개인적인 견해로 전자를 추천합니다-
			List<Post_BoardVO> list= post_boardBIZ.getSearch_Post_Board_User(s);
			System.out.println("Post_BoardServlet->List<Post_BoardVO> list = "+list.size());
			m.addAttribute("all",list);
		return "post_boardView/user_post_board";
		}
	@RequestMapping(value="/search_hugi.do",method=RequestMethod.GET)
	 public String post_board_search_hugi(HttpServletRequest request,Model m) {
			String s=request.getParameter("search_post_board_hugi");
			System.out.println("search_post_board_hugi(입력받은 검색어) = "+s);
			List<Post_BoardVO> list= post_boardBIZ.getSearch_Post_Board_Hugi(s);
			m.addAttribute("list",list);
		return "post_boardView/hugi_post_board";
		}
	
	
	
	

	
	
}
