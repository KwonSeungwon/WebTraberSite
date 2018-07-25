package com.acoda.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.acoda.vo.FestivalVO;

@Repository
public class FestivalDAO implements IFestival {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<FestivalVO> getAllFestival(){
		
		
		List<FestivalVO> all=jdbcTemplate.query(select_festival,new RowMapper<FestivalVO>() {

			@Override
			public FestivalVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				FestivalVO vo=new FestivalVO();
				System.out.println(rs.getInt("f_number"));
				vo.setF_number(rs.getInt("f_number"));
				vo.setF_name(rs.getString("f_name"));
				vo.setSeason(rs.getString("season"));
				vo.setF_start_date(rs.getString("f_start_date"));
				vo.setF_end_date(rs.getString("f_end_date"));
				vo.setF_local(rs.getString("f_local"));
				return vo;
			}
		});
		return all;
		
	}
	
	public int getDelFestival(String del_name) {
		int f = jdbcTemplate.update(delete_festival,del_name );
		
		
		return f;
		
	}
	
	public int getInsertFestival(FestivalVO vo) {
		int f=jdbcTemplate.update(insert_festival,new Object[] {vo.getF_number(), vo.getSeason(), vo.getF_name(), vo.getF_start_date(),
                vo.getF_end_date(), vo.getF_local(), vo.getF_contents(), vo.getUser_number()} );
		 
		if (f > 0) {
	         return f;
	      } else {
	         return 0;
	      }
		
	}
	
	public FestivalVO getFindFestival(String find_festival) {
		
		FestivalVO  f=(FestivalVO) jdbcTemplate.query(find_festival,new Object[] {find_festival},new RowMapper<FestivalVO>() {

			@Override
			public FestivalVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			FestivalVO vo=new FestivalVO();
			
			vo.setF_number(rs.getInt("f_number"));
			vo.setF_name(rs.getString("f_name"));
			vo.setSeason(rs.getString("season"));
			vo.setF_start_date(rs.getString("f_start_date"));
			vo.setF_end_date(rs.getString("f_end_date"));
			vo.setF_local(rs.getString("f_local"));
			//vo.setUser_number(rs.getInt("user_number"));
				return vo;
			}
			
		});
		
		
		return f ;
		
	}
	
	public int getUpdateFestival(FestivalVO vo) {
		int f = jdbcTemplate.update(update_festival, new Object[] {vo.getSeason(),vo.getF_name(),vo.getF_start_date(),
	            vo.getF_end_date(),vo.getF_local(),vo.getF_contents(),vo.getUser_number(),vo.getF_number()});
		
		return f;
		
	}

}
