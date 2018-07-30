package com.acoda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.acoda.biz.UserInfoBiz;
import com.acoda.dao.UserLoginDao;
import com.acoda.vo.MemberVO;

@Controller
public class UserInfoController {

	// 비즈 오토라이드
	@Autowired
	private UserInfoBiz infoBiz;

	// 인서트 컨트롤러
	@RequestMapping(value = "/abc.do", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("userInfo") MemberVO vo, HttpSession session,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		System.out.println("컨트롤러 도착" + vo.getUser_number());
		System.out.println(vo.getRating() + vo.getJoindate());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		vo.setJoindate(today);
		ModelAndView mav = new ModelAndView();				
		if (vo.getRating() == 2) {
			String result = infoBiz.insert(vo);
			mav = new ModelAndView("UserView/InsertResult", "myresult", result);
			session.setAttribute("login", vo);
		} else if(vo.getRating() == 1)  {
			String result2 = infoBiz.insertNomal(vo);
			mav = new ModelAndView("UserView/InsertResult", "myresult", result2);
			session.setAttribute("login", vo);
		}
		return mav;
	}

	// 유저리스트 컨트롤러
	@RequestMapping("/Select.do")
	public ModelAndView select() {
		List<MemberVO> list = infoBiz.select();
		ModelAndView mav = new ModelAndView("UserView/UserAllList", "list", list);

		return mav;
	}

	// 딜리트 컨트롤러
	@RequestMapping(value = "deleteuser.do", method = RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute("userInfo") MemberVO vo, HttpServletResponse rep, HttpSession session) throws IOException {
		System.out.println("받은 아이디 :" + vo.getId() + vo.getPw());
		ModelAndView mav = new ModelAndView();
		if (infoBiz.logincheck(vo) == 0) {
			mav = new ModelAndView("/UserView/DeleteUserResult", "myid", vo);
			infoBiz.delete(vo);
			session.invalidate();
			System.out.println("삭제완료");

		} else {
			PrintWriter out = rep.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('Please Check your ID&PW');");
			out.println("history.back();");
			out.println("</script>");
			System.out.println("삭제실패");
			out.flush();
			out.close();

		}
		return mav;
	}

	@RequestMapping(value = "/idcheck.do", method = RequestMethod.GET)
	public @ResponseBody  String Idcheck(@RequestParam String id,Model mv,HttpServletResponse response) throws IOException {
		String result = "";
		 if(infoBiz.checkId(id) == true) {
			 result = "good";
			 mv.addAttribute("login",result);
			 return result;
		 }else {
			 result = "bad";
			 mv.addAttribute("login",result);
			 return result;

		 }
		 
	
		 


	}

}
