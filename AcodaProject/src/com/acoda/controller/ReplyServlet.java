package com.acoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.acoda.biz.ReplyBIZ;
import com.acoda.vo.ReplyVO;

@Controller
public class ReplyServlet {
	
	@Autowired
	ReplyBIZ replyBIZ;
	
	public String Reply_Select(Model m) {
		return null;
		
	}
	
	public String Reply_Insert(ReplyVO vo) {
		return null;
		
	}
	
	public String Reply_insertpage() {
		return null;
		
	}
	
	public String Reply_find() {
		return null;
	}
	
	public String Reply_delete() {
		return null;
	}
	
	public String Reply_update() {
		return null;
	}

}
