package com.acoda.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acoda.dao.FestivalDAO;
import com.acoda.vo.FestivalVO;

@Service
public class FestivalBIZ {
	
	@Autowired
	FestivalDAO festivalDAO;
	
	public List<FestivalVO> getAllFestival(){
		return null;
		
	}
	
	public int getInsertFestival(FestivalVO vo) {
		return 0;
		
	}
	
	public FestivalVO getFindFestival(String name) {
		return null;
		
	}
	
	public int getDelFestival(String del_name) {
		return 0;
		
	}
	
	public int getUpdateFestival(FestivalVO vo) {
		return 0;
	}
	

}
