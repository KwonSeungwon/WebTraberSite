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

	public int getInsertFestival(FestivalVO vo) {
		System.out.println("여기는 인서트 비즈임");
		FestivalVO fe = new FestivalVO();
		fe.setF_number(vo.getF_number());
		fe.setF_name(vo.getF_name());
		fe.setSeason(vo.getSeason());
		fe.setF_start_date(vo.getF_start_date());
		fe.setF_end_date(vo.getF_end_date());
		fe.setF_local(vo.getF_local());
		fe.setF_contents(vo.getF_local());
		return festivalDAO.getInsertFestival(fe);

	}

	public FestivalVO getFindFestival(String name) {
		
		return null;

	}

	public int getDelFestival(String del_name) {
		
		return festivalDAO.getDelFestival(del_name);

	}

	public int getUpdateFestival(FestivalVO vo) {
		return 0;
	}

}
