package com.acoda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.acoda.vo.ReplyVO;


@Repository
public class ReplyDAO implements IReply{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ReplyVO> getAllReply(){
		return null;
		
	}
	
	public int getDelReply(String del_name) {
		return 0;
		
	}
	
	public int getInsertReply(ReplyVO vo) {
		return 0;
		
	}
	
	public ReplyVO getFindFestival(String find_reply) {
		return null;
		
	}
	
	public int getUpdateReply(ReplyVO vo) {
		return 0;
		
	}

}
