package com.acoda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.acoda.vo.Post_BoardVO;


@Repository
public class Post_BoardDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Post_BoardVO> getAllPost_Board(){
		return null;
		
	}
	
	public int getDelPost_Board(String del_name) {
		return 0;
		
	}
	
	public int getInsertPost_Board(Post_BoardVO vo) {
		return 0;
		
	}
	
	public Post_BoardVO getFindPost_Board(String find_post_board) {
		return null;
		
	}
	
	public int getUpdatePost_Board(Post_BoardVO vo) {
		return 0;
		
	}

}
