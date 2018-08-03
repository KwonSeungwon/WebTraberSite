package com.acoda.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acoda.dao.ReplyDAO;
import com.acoda.vo.Post_BoardVO;
import com.acoda.vo.ReplyVO;

@Service
public class ReplyBIZ {

	@Autowired
	ReplyDAO replyDAO;
	
	public List<ReplyVO> getAllReply(String click_post_number){
		System.out.println("ReplyBIZ 의 getAllReply 호출 , click_post_number = " + click_post_number);
		return replyDAO.getAllReply(click_post_number);
		
	}
	
	public int getInsertReply(ReplyVO vo) {
		ReplyVO rvo = new ReplyVO();
		rvo.setPost_number(vo.getPost_number());
		rvo.setUser_number(vo.getUser_number());
		rvo.setR_date(vo.getR_date());
		rvo.setR_comment(vo.getR_comment());
		
		return replyDAO.getInsertReply(rvo);
		
	}
	
	
	public int getDelReply(String del_r_number,String find_post_number) {
		return replyDAO.getDelReply(del_r_number,find_post_number);
		
	}
	
	public int getUpdateReply(ReplyVO vo) {
		ReplyVO rvo = new ReplyVO();
		rvo.setR_comment(vo.getR_comment());
		rvo.setR_number(vo.getR_number());
		rvo.setPost_number(vo.getPost_number());
		System.out.println("ReplyBIZ -> getUpdateReply호출");
		return replyDAO.getUpdateReply(rvo);
	}
}
