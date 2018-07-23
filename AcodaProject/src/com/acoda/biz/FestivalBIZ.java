package com.acoda.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acoda.dao.FestivalDAO;

@Service
public class FestivalBIZ {
	
	@Autowired
	FestivalDAO festivalDAO;

}
