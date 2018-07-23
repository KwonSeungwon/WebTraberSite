package com.acoda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acoda.dao.UserLoginDao;
import com.acoda.vo.MemberVO;

@Controller
public class UserloginController {
	
	@Autowired
	UserLoginDao userlogindao;
	

	@RequestMapping(value ="/input/logincheck.do")
	public void loginCheck(Locale locale, Model model,MemberVO vo, HttpSession session, HttpServletResponse response) throws IOException {
		response.setContentType("charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if((vo.getId()!= null && vo.getId().equals("") && vo.getPw() != null && vo.getPw().equals(""))) {
			session.setAttribute("login",0);
			
			out.print("<script>location.href='index.jsp';</script>");
			out.flush();
			out.close();
			
		}
		
		if(userlogindao.LoginCheck(vo) == false) {
			out.println("<script>alert('로그인 정보확인'); history.go(-1)</script>");
			out.flush();
			out.close();
		}
		
		
		
	}
	
	 
	
	
	
	
	
	
	
	

}
