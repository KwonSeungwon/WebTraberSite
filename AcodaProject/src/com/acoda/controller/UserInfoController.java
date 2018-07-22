package com.acoda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.acoda.biz.UserInfoBiz;
import com.acoda.vo.MemberVO;

@Controller
public class UserInfoController {

	// 비즈 오토라이드
	@Autowired
	private UserInfoBiz infoBiz;

	// 인서트 컨트롤러
	@RequestMapping(value = "/abc.do", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("userInfo") MemberVO vo) {
		System.out.println("컨트롤러 도착" + vo.getUsernumber());
		String result = infoBiz.insert(vo);
		ModelAndView mav = new ModelAndView("UserView/InsertResult", "myresult", result);
		// 출력파일 : result.jsp, 꺼내올 객체명(request객체) : myresult, 전송할 객체 : result
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
	public ModelAndView delete(@ModelAttribute("userInfo") MemberVO vo) {
		System.out.println("받은 아이디 :" + vo.getId() + vo.getPw());
		ModelAndView mav = new ModelAndView("UserView/DeleteUserResult", "myid", vo);
		infoBiz.delete(vo);
		return mav;
	}

}
