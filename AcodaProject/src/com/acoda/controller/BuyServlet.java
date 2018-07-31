package com.acoda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acoda.biz.BuyBIZ;
import com.acoda.vo.BuyVO;
import com.acoda.vo.MemberVO;
import com.acoda.vo.Post_BoardVO;

@Controller
public class BuyServlet {

	@Autowired
	BuyBIZ buyBIZ;

	// 주문 상품 조회
	@RequestMapping("/UserOrderList.do")
	public ModelAndView Buy_Select(HttpSession session, HttpServletResponse response) throws IOException { // 컨트롤러 매개변수는
																											// 뷰단에서 변수를
																											// 받아와야함.

		MemberVO mvo = (MemberVO) session.getAttribute("login");
		int unumber = mvo.getUser_number();
		ModelAndView mav = new ModelAndView();

		if (unumber > 0) {
			List<BuyVO> all = buyBIZ.BuyAllSelectBiz(unumber);
			mav = new ModelAndView("/UserOdrer/UserOrderList", "BuyList", all);

		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('Error! you have no item!');");
			out.println("history.back();");
			out.println("</script>");
		}
		return mav;

	}

	public String Buy_Insert(BuyVO vo) {
		return null;

	}

	public String Buy_insertpage() {
		return null;

	}

	public String Buy_find() {
		return null;
	}

	// 주문 상품 취소
	@RequestMapping("/deleteorder.do")
	public ModelAndView Buy_delete(@RequestParam("del_itemnum") int itemnum, HttpServletResponse response,
			HttpSession session) {

		MemberVO mvo = (MemberVO) session.getAttribute("login");
		int unumber = mvo.getUser_number();
		ModelAndView mav = new ModelAndView();

		if (buyBIZ.getDelBuy(itemnum) > 0) {
			System.out.println("삭제끝");
			List<BuyVO> all = buyBIZ.BuyAllSelectBiz(unumber);
			mav = new ModelAndView("/UserOdrer/UserOrderList", "BuyList", all);

		}
		return mav;

	}

	public String Buy_update() {
		return null;
	}
}
