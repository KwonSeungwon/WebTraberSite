package com.acoda.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import com.acoda.biz.FestivalBIZ;
import com.acoda.dao.FestivalDAO;
import com.acoda.vo.FestivalVO;

@Controller
@RequestMapping("/festival")
public class FestivalServlet {

	@Autowired
	FestivalBIZ festivalBIZ;

	//list보여주는곳.
	@RequestMapping("/select.do")
	public String f_Select(Model m) {
		List<FestivalVO> all = festivalBIZ.getAllFestival();

		m.addAttribute("all", all);
		return "festival/list_festival";

	}
	//insert
	@RequestMapping(value ="/insert.do", method=RequestMethod.GET)
	public ModelAndView f_insert(@ModelAttribute FestivalVO vo) {
		System.out.println("여기는 인서트 추가하는 곳");
		int r = festivalBIZ.getInsertFestival(vo);
		InternalResourceView irv = new InternalResourceView("/festival/select.do");
		return new ModelAndView(irv);

	}
	//insert페이지로 넘어감
	@RequestMapping("/insert_page.do")
	public ModelAndView Festival_insertpage() {
		System.out.println("여기서 넘어가는건가?");

		InternalResourceView irv = new InternalResourceView("/input/input_festival.jsp");

		return new ModelAndView(irv);

	}

	//삭제
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView Festival_delete(@RequestParam("del_name") String name) {
		System.out.println("여긴 컨트롤러 딜리트");
		InternalResourceView irv = new InternalResourceView("/festival/select.do");

		int r = festivalBIZ.getDelFestival(name);
		if (r > 0) {
			System.out.println("여기까지느 온다");
			return new ModelAndView(irv);
		} else {
			System.out.println("삭제오류");
			return null;
		}
	}
	//파인드
	@RequestMapping(value = "/find.do", method = RequestMethod.GET)
	public ModelAndView Festival_find(@RequestParam("find_number") String find_number, Model m) {
		System.out.println("여기는 파인드" + find_number);
		FestivalVO v = festivalBIZ.getFindFestival(find_number);
		m.addAttribute("find", v);
		
		InternalResourceView irv = new InternalResourceView("/input/update.jsp");
		ModelAndView mav=new ModelAndView(irv);
		return mav;
	}
	//업데이트
	@RequestMapping(value="/update.do")
	public ModelAndView Festival_update(@ModelAttribute("festivalvo") FestivalVO vo) {
		System.out.println("여기는 업데이트");
		
		int f = festivalBIZ.getUpdateFestival(vo);
		InternalResourceView irv = new InternalResourceView("/festival/select.do");
		return new ModelAndView(irv) ;
	}
	//검색
	@RequestMapping(value="/search.do",method=RequestMethod.GET)
 public String search(HttpServletRequest request,Model m) {
		String s=request.getParameter("searchkeyword");
		List<FestivalVO> list= festivalBIZ.getsearch(s);
		
	 System.out.println("여기는 서치");
		
		m.addAttribute("list",list);
		
		
	return "festival/getboardList";
	}

	

}
