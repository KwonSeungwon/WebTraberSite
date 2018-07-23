package com.acoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.acoda.biz.BuyBIZ;

@Controller
public class BuyServlet {

	@Autowired
	BuyBIZ buyBIZ;
}
