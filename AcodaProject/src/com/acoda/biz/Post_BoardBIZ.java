package com.acoda.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acoda.dao.Post_BoardDAO;
import com.acoda.vo.Post_BoardVO;


@Service
public class Post_BoardBIZ {
	
	
	@Autowired
	Post_BoardDAO post_boardDAO;
	
	public List<Post_BoardVO> getAllPost_Board(){
		return post_boardDAO.getAllPost_Board();
	}
	
	
	public int getInsert_User_Post_Board(Post_BoardVO vo) {
		System.out.println("Post_BoardBIZÀÇ getInsertPost_Board ½ÇÇà");
		Post_BoardVO pvo = new Post_BoardVO();
		pvo.setUser_number(vo.getUser_number());
		pvo.setPost_number(vo.getPost_number());
		pvo.setPost_title(vo.getPost_title());
		pvo.setPost_contents(vo.getPost_contents());
		pvo.setRegistration_date(vo.getRegistration_date());
		pvo.setViews(vo.getViews());
		pvo.setPath(vo.getPath());
		return post_boardDAO.getInsert_UserPost_Board(pvo);
	}
	
	public Post_BoardVO getFindPost_Board(String name) {
		return null;
	
	}

	
	
	public int getDelPost_Board(String del_id) {
		
		return post_boardDAO.getDelPost_Board(del_id);
		
	}
	
	public int getUpdatePost_Board(Post_BoardVO vo) {
		return 0;
	}
}
