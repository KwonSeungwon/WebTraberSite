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
import org.springframework.web.bind.annotation.RequestMethod;

import com.acoda.biz.UserInfoBiz;
import com.acoda.dao.UserLoginDao;
import com.acoda.vo.MemberVO;

@Controller
public class UserloginController {

	@Autowired
	private UserInfoBiz userBiz ;

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public void loginCheck(Locale locale, Model model, MemberVO vo, HttpSession session, HttpServletResponse response)
			throws IOException {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
		if(userBiz.logincheck(vo) != 0){
			vo = userBiz.logincheck2(vo);
			System.out.println("true");
			session.setAttribute("login",vo);
			System.out.println("세션추가완료" + vo.getUser_number());
			response.sendRedirect("index.jsp");
			out.flush();
			out.close();

		} else {
			out.println("<script type='text/javascript'>");
			out.println("alert('아이디 또는 비밀번호를 확인해주세요!');");
			out.println("history.back();");
			out.println("</script>");
			System.out.println("false");
			out.flush();
			out.close();
		}

	}

	@RequestMapping(value = "/logout.do")
	public void logout(HttpSession session, HttpServletResponse response) throws IOException {

		if (session != null) {
			session.invalidate();
			response.sendRedirect("index.jsp");
			System.out.println("세션종료");
		}
	}

}
