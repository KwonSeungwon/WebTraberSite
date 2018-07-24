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
public class Post_BoardDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Post_BoardVO> getAllPost_Board(){
		List<Post_BoardVO> all = jdbcTemplate.query(com.acoda.dao.IPost_Board.select_post, new RowMapper<Post_BoardVO>() {
			public Post_BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post_BoardVO vo = new Post_BoardVO(rs.getInt("post_number"),rs.getString("title"), rs.getString("id"), rs.getString("post_title"), rs.getString("registration_date"), rs.getInt("views"));
				return vo;
			}
		});
		return all;
		
	}
	
	public int getDelPost_Board(String del_name) {
		return 0;
		
		
	}
	
	public int getInsertPost_Board(Post_BoardVO vo) {
		int r = jdbcTemplate.update(com.acoda.dao.IPost_Board.insert_post,
				new Object[] {vo.getP_type(),vo.getTitle(),vo.getTitle_number(),vo.getId(),vo.getPost_number(),vo.getPost_title(),vo.getPost_contents(),vo.getRegistration_date(),vo.getViews() });
		if (r > 0) {
			return r;
		} else {
			return 0;
		}
	}
	
	public Post_BoardVO getInsert_Find_Post_Board(String find_post_board) {
		Post_BoardVO vo = jdbcTemplate.queryForObject(com.acoda.dao.IPost_Board.insert_post,new Object[] {find_post_board},
				new RowMapper<Post_BoardVO>() {

			@Override
			public Post_BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post_BoardVO s= new Post_BoardVO(rs.getInt("p_type"),rs.getString("title"),rs.getInt("title_number"),rs.getString("id"),rs.getInt("post_number"),
						rs.getString("post_title"),rs.getString("post_contents"),rs.getString("registration_date"),rs.getInt("views"),rs.getString("path"),rs.getInt("user_number"));
				return s;
			}
		});
		return vo;
		
	}
	
	public int getUpdatePost_Board(Post_BoardVO vo) {
		return 0;
		
	}

}
