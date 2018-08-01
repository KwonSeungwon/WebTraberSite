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

	public List<FestivalVO> getAllFestival() {
		System.out.println("여긴 비즈");
		System.out.println(festivalDAO.getAllFestival().toString());
		return festivalDAO.getAllFestival();

	}
	//검색
	public List<FestivalVO> getsearch(String s){
		System.out.println("여기서 검색한다....");
		System.out.println(festivalDAO.getsearch(s).size());
		return  festivalDAO.getsearch(s);
	}
	//click
	public List<FestivalVO> getClickfestival(String name){
	System.out.println("여기는 클릭 비즈 : "+name.toString());
		return festivalDAO.getClickfestival(name);
	}

	 public int getInsertFestival(FestivalVO vo) {

	      return festivalDAO.getInsertFestival(vo);
	   }

	public FestivalVO getFindFestival(String name) {
		System.out.println("여기는 파인드 비즈"+name);
		return festivalDAO.getFindFestival(name);

	}

	public int getDelFestival(String del_name) {
		
		return festivalDAO.getDelFestival(del_name);

	}

	public int getUpdateFestival(FestivalVO vo) {
		System.out.println("여기는 업데이트 비즈"+festivalDAO.getUpdateFestival(vo));
		
		return festivalDAO.getUpdateFestival(vo);
	}

}
