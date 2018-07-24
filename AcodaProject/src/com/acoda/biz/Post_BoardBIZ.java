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
	
	public int getInsertPost_Board(Post_BoardVO vo) {
		Post_BoardVO pvo = new Post_BoardVO();
		pvo.setP_type(vo.getP_type());
		pvo.setTitle(vo.getTitle());
		pvo.setTitle_number(vo.getTitle_number());
		pvo.setUser_number(vo.getUser_number());
		pvo.setPost_number(vo.getPost_number());
		pvo.setPost_title(vo.getPost_title());
		pvo.setPost_contents(vo.getPost_contents());
		pvo.setViews(vo.getViews());
		return post_boardDAO.getInsertPost_Board(pvo);
	}
	
	public Post_BoardVO getFind_Post_Board(String name) {
		return null;
	
	}

}
