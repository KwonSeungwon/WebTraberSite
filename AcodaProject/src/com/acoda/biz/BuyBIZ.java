package com.acoda.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acoda.dao.BuyDAO;

@Service
public class BuyBIZ {

	@Autowired
	BuyDAO buyDAO;

}
