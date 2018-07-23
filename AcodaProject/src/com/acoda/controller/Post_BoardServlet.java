package com.acoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.acoda.biz.Post_BoardBIZ;

@Controller
public class Post_BoardServlet {

	@Autowired
	Post_BoardBIZ post_boardBIZ;
	
}
