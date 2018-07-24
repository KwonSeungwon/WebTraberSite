package com.acoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.acoda.biz.FestivalBIZ;

@Controller
public class FestivalServlet {
	
	@Autowired
	FestivalBIZ festivalBIZ;

	
	
}
