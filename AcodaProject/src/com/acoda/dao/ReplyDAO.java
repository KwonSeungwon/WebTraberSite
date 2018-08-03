package com.acoda.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.acoda.vo.Post_BoardVO;
import com.acoda.vo.ReplyVO;


@Repository
public class ReplyDAO implements IReply{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ReplyVO> getAllReply(String click_post_number){
		System.out.println("ReplyDAO 의 getAllReply 호출+ click_post_number = " +  click_post_number);
		List<ReplyVO> replyall = jdbcTemplate.query(select_reply, new Object[] {click_post_number}, new RowMapper<ReplyVO>() {
			public ReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ReplyVO vo = new ReplyVO(rs.getInt("r_number"),rs.getString("r_date"),rs.getString("r_comment"),rs.getString("id"),rs.getInt("post_number"));
				System.out.println("ReplyDAO 의 getAllReply에서 vo값");
				System.out.println(vo.toString());
				return vo;
			}
		});
		return replyall;
		
	}
	
	public int getDelReply(String del_r_number,String find_post_number) {
		System.out.println("ReplyDAO.getDelReply 호출   : "+",del_r_number : " + del_r_number);
		this.getUpdateViewsMinus(find_post_number);
		int r = jdbcTemplate.update(delete_reply,del_r_number);
		return r;
		
	}
	
	public int getInsertReply(ReplyVO vo) {
		this.getUpdateViewsMinus(Integer.toString(vo.getPost_number()));
		int r = jdbcTemplate.update(insert_reply,
				new Object[] {vo.getPost_number(),vo.getUser_number(),vo.getR_date(),vo.getR_comment()});
		if (r > 0) {
			return r;
		} else {
			return 0;
		} 
		
	}
	
	public int getUpdateReply(ReplyVO vo) {
		this.getUpdateViewsMinus(Integer.toString(vo.getPost_number()));
		int r = jdbcTemplate.update(update_reply,new Object[] {vo.getR_comment(),vo.getR_number()});
		return r;
		
	}
	
	public int getUpdateViewsMinus(String click_post_number) {
		return jdbcTemplate.update(update_viewscount_minus,click_post_number);
	}
}
