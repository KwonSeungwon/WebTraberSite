package com.acoda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.acoda.vo.FestivalVO;

@Repository
public class FestivalDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<FestivalVO> getAllFestival(){
		return null;
		
	}
	
	public int getDelFestival(String del_name) {
		return 0;
		
	}
	
	public int getInsertFestival(FestivalVO vo) {
		return 0;
		
	}
	
	public FestivalVO getFindFestival(String find_festival) {
		return null;
		
	}
	
	public int getUpdateFestival(FestivalVO vo) {
		return 0;
		
	}

}
