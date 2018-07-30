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
		
		FestivalVO f=new FestivalVO();
		f.setF_number(vo.getF_number());
		f.setF_name(vo.getF_name());
		f.setSeason(vo.getSeason());
		f.setF_start_date(vo.getF_start_date());
		f.setF_end_date(vo.getF_end_date());
		f.setF_local(vo.getF_local());
		f.setF_contents(vo.getF_contents());
		f.setUser_number(vo.getUser_number());
		
		return festivalDAO.getUpdateFestival(f);
	}

}
