package com.acoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.acoda.biz.ReplyBIZ;

@Controller
public class ReplyServlet {
	
	@Autowired
	ReplyBIZ replyBIZ;

}
