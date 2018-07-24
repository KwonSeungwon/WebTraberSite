package com.acoda.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acoda.dao.ReplyDAO;
import com.acoda.vo.ReplyVO;

@Service
public class ReplyBIZ {

	@Autowired
	ReplyDAO replyDAO;
	
	public List<ReplyVO> getAllReply(){
		return null;
		
	}
	
	public int getInsertReply(ReplyVO vo) {
		return 0;
		
	}
	
	public ReplyVO getFindReply(String name) {
		return null;
		
	}
	
	public int getDelReply(String del_name) {
		return 0;
		
	}
	
	public int getUpdateReply(ReplyVO vo) {
		return 0;
	}
}
