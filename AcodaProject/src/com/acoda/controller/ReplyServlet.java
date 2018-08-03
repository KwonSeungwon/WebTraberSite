package com.acoda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/reply")
public class ReplyServlet {
	
	@Autowired
	ReplyBIZ replyBIZ;
	
	@Autowired
	Post_BoardBIZ post_boardBIZ;
	
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String Reply_Insert(ReplyVO vo) {
		int r = replyBIZ.getInsertReply(vo);
		return "redirect:/post_board/click.do?click_post_number="+vo.getPost_number();
	}
	
	@RequestMapping(value="/delete.do", method=RequestMethod.GET)
	public String Reply_delete(@RequestParam("del_r_number") String del_r_number,@RequestParam("find_post_number") String find_post_number) {
		int r = replyBIZ.getDelReply(del_r_number,find_post_number);
		System.out.println("ReplyServlet -> /reply/delete.do 실행");
		System.out.println("ReplyServlet 에서 삭제할 게시글 번호 del_r_number값  : "+del_r_number);
		
		Post_BoardVO vo = post_boardBIZ.getFindPost_Board(find_post_number);
		if(r>0) {
			System.out.println("ReplyServlet 에서 click_post_number로 보내줄 vo.getPost_number()값 : "+vo.getPost_number());
			return "redirect:/post_board/click.do?click_post_number="+vo.getPost_number();
		}else {
			return null;
		}
	}
	
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public String Reply_update(ReplyVO vo) {
		int r = replyBIZ.getUpdateReply(vo);
		System.out.println("ReplyServlet ->Reply_update 호출 -> 받아온 vo.getPost_number()값 : " +vo.getPost_number());
		return "redirect:/post_board/click.do?click_post_number="+vo.getPost_number();
	}

}
