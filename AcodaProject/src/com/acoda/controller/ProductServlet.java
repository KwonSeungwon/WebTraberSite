package com.acoda.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import com.acoda.biz.BuyBIZ;
import com.acoda.biz.ProductBIZ;
import com.acoda.vo.BuyVO;
import com.acoda.vo.MemberVO;
import com.acoda.vo.ProductVO;

@Controller
@RequestMapping("/product")
public class ProductServlet {

	
	
	
	@Autowired
	ProductBIZ productBIZ;
	@Autowired
	BuyBIZ buyBIZ;

	/////////// 전체출력이지만 일부만 출력함.////////////////////////////////////////////////////////
	@RequestMapping("/select.do")
	public String Product_Select(Model m) {

		List<ProductVO> list = productBIZ.getAllProduct();
		m.addAttribute("list", list);
		return "product/list_product";
	}

	//////// 실제 추가 /////////////////////////////////////////////////////////
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public ModelAndView Product_Insert(@ModelAttribute ProductVO vo) throws IOException {

		System.out.println("상품 추가 컨트롤러");
		vo.setTrip_date(vo.getTrip_date().replace(",", "~"));
		int p = productBIZ.getInsertProduct(vo);// sql문(insert)실행

		List<ProductVO> list = productBIZ.getAllProduct();// 실행된 결과를 목록에 넣어서 보여줌.
		ModelAndView m = new ModelAndView("/product/list_product", "list", list);

		return m;
	}


	//////////////// 검색하기  기능 /////////////////////////////////////
	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public String search(HttpServletRequest req, Model m) {
		System.out.println("상품 검색 컨드롤러");
		String name = req.getParameter("searchkeyword");
		List<ProductVO> pvo = productBIZ.getSearch_product(name);
		m.addAttribute("pvo", pvo);
		return "product/get_product_List";
	}
	
	
	
	////////////// 상품 상세정보 ///////////////////////////////////////////////
	@RequestMapping(value = "/productdetail.do", method = RequestMethod.GET)
	public ModelAndView Product_deatail(@RequestParam("item_number") int item_num) {
		
		ModelAndView mav = new ModelAndView();
		ProductVO vo = new ProductVO();
		vo = productBIZ.getDetail(item_num);
		System.out.println(vo.getPic());
		mav = new ModelAndView("/product/click_product", "clist", vo);
		return mav;
	}







	@RequestMapping("delete.do")
	public ModelAndView Product_delete(@RequestParam("del_number") String name) {
		int p = productBIZ.getDelProduct(name);
		ModelAndView m = new ModelAndView();

		if (p > 0) {
			List<ProductVO> list = productBIZ.getAllProduct();
			m = new ModelAndView("/product/list_product", "list", list);

			return m;

		} else {
			return null;
		}

	}

	//////// 상품 업데이트 //////////////////////////////////////////
	@RequestMapping("/productupdate.do")
	public ModelAndView Product_update(@ModelAttribute("find_number") ProductVO vo) {
		List<ProductVO> list = productBIZ.getAllProduct();
		ModelAndView mav = new ModelAndView();
		vo.setTrip_date(vo.getTrip_date().replace(",", "~"));
		int n = productBIZ.getUpdateProduct(vo);
		System.out.println(n+"여기는 컨트롤러");
		if (n > 0) {
			System.out.println("수정성공");
			list = productBIZ.getAllProduct();
		}
		mav = new ModelAndView("/product/list_product","list",list);


		return mav;
	}

	// 수정전 상품 리스트 가져오기//////////////////////////////////
	@RequestMapping("/pupinfo.do")
	public InternalResourceView Product_getupdateinfo(@RequestParam("item_number") int num,Model m) {
		ProductVO vo = new ProductVO();
		vo = productBIZ.getproductupdateinfo(num);

		InternalResourceView irv = new InternalResourceView("/input/ProductUpdate.jsp");
		m.addAttribute("ulist",vo);

		
		return irv;

	}

	// 사진업로드 AJAX //////////////////////////////////////
	@RequestMapping(value = "/picup.do", method = RequestMethod.POST)
	public @ResponseBody String Product_Select(MultipartHttpServletRequest uploadFile,HttpSession session,
			HttpServletRequest rep) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd ss");
		String dd = sdf.format(new Date());
		
		MemberVO vo = (MemberVO) session.getAttribute("login");
		String result = "";
		String f_realname = "";
		String path = "C:\\Users\\Playdata\\git\\Encore_1jooo\\AcodaProject\\WebContent\\img\\";; // 파일 저장경로
		File dir = new File(path);
		if (!dir.isDirectory()) {
			dir.mkdir();
		}
		Iterator<String> files = uploadFile.getFileNames();
		while (files.hasNext()) {
			String upload = files.next();
			MultipartFile mult = uploadFile.getFile(upload);
			f_realname = mult.getOriginalFilename();
			mult.transferTo(new File(path +vo.getId()+"_"+dd+"_"+f_realname));
		}
		result = path + vo.getId()+"_" +dd+"_"+f_realname;

		
		String abc[] = result.split("\\\\");
		String a = "../";
		for(int i = 0 ;i<abc.length ; i++) {
			if(abc[i].equals("img")) {
				result = a+abc[i]+"/"+abc[i+1];
			}
				
		}
		
		System.out.println(result);
		return result;

	}

	// 신청서 페이지 이동
	@RequestMapping(value = "/click.do", method = RequestMethod.GET)
	public ModelAndView Buy_Insert(@RequestParam("click_number") String item_number) {
		/* int b=buyBIZ.getInsertBuy(vo); */
		InternalResourceView irv = new InternalResourceView("/input/application_form.jsp");
		ModelAndView m = new ModelAndView(irv, "b", item_number);

		return m;

	}
	//신청서 확인 페이지로 이동
	@RequestMapping(value="/aplication.do")
	public ModelAndView Buy_aplication_page(@RequestParam("aplic_number") int a) {	
		//InternalResourceView irv = new InternalResourceView("/input/aplication_confirm.jsp");
		List<BuyVO> list=buyBIZ.getApllication_list(a);
		ModelAndView m=new ModelAndView("UserOrder/aplication_confirm","list",list);
		return m;

	}

}
