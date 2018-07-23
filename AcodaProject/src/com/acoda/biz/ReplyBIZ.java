package com.acoda.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acoda.dao.ReplyDAO;

@Service
public class ReplyBIZ {

	@Autowired
	ReplyDAO replyDAO;
	
}
