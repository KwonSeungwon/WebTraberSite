package com.acoda.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.acoda.vo.Post_BoardVO;



@Repository
public class Post_BoardDAO implements IPost_Board {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Post_BoardVO> getAllPost_Board(){
		List<Post_BoardVO> all = jdbcTemplate.query(select_post, new RowMapper<Post_BoardVO>() {
			public Post_BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post_BoardVO vo = new Post_BoardVO(rs.getInt("post_number"),rs.getString("title"), rs.getString("id"), rs.getString("post_title"), rs.getString("registration_date"), rs.getInt("views"));
				return vo;
			}
		});
		return all;
		
	}
	
	
	public int getDelPost_Board(String del_id) {
		int r = jdbcTemplate.update(delete_post,del_id);
		return r;
		
		
	}
	
	public int getInsert_UserPost_Board(Post_BoardVO vo) {
		int r = jdbcTemplate.update(insert_post_user,
				new Object[] {vo.getUser_number(),vo.getPost_number(),vo.getPost_title()
						,vo.getPost_contents(),vo.getRegistration_date(),vo.getViews(),vo.getPath()});
		if (r > 0) {
			System.out.println("Post_BarodDAO 의 InsertPost_Board if문 r>0");
			return r;
		} else {
			System.out.println("Post_BarodDAO 의 InsertPost_Board if문 else");
			return 0;
		} 
	}
	
	
	
	public int getUpdatePost_Board(Post_BoardVO vo) {
		return 0;
		
	}

}
