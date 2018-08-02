package com.acoda.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

import com.acoda.biz.ProductBIZ;
import com.acoda.vo.MemberVO;
import com.acoda.vo.ProductVO;

@Controller
@RequestMapping("/product")
public class ProductServlet {

	@Autowired
	ProductBIZ productBIZ;

	// 전체출력이지만 일부만 출력함.////////////////////////////////////////////////////////
	@RequestMapping("/select.do")
	public String Product_Select(Model m) {

		List<ProductVO> list = productBIZ.getAllProduct();
		m.addAttribute("list", list);
		return "product/list_product";
	}

	// 실제 추가 /////////////////////////////////////////////////////////
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public ModelAndView Product_Insert(@ModelAttribute ProductVO vo) throws IOException {

		System.out.println("상품 추가 컨트롤러");
		int p = productBIZ.getInsertProduct(vo);// sql문(insert)실행

		List<ProductVO> list = productBIZ.getAllProduct();// 실행된 결과를 목록에 넣어서 보여줌.
		ModelAndView m = new ModelAndView("/product/list_product", "list", list);

		return m;
	}

	// 상품 디테일 /////////////////////////////////////////////////////////
	@RequestMapping(value = "/productdetail.do", method = RequestMethod.GET)
	public ModelAndView Product_deatail(@RequestParam("item_number") int item_num) {


		ModelAndView mav = new ModelAndView();
		ProductVO vo = new ProductVO();
		vo = productBIZ.getDetail(item_num);
		System.out.println(vo.getPic());
		String result = "";
		String a = "../";
		String sp = vo.getPic();
		String[] change = sp.split("\\\\");
		result = a + change[7] + "/" + change[8];
		vo.setPic(result);
		mav = new ModelAndView("/product/click_product", "clist", vo);

		return mav;
	}

	// 상품삭제 ////////////////////////////////////////////////////////////////
	@RequestMapping("/delete.do")
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

	public String Product_update() {
		return null;
	}

	// 사진업로드 AJAX //////////////////////////////////////
	@RequestMapping(value = "/picup.do", method = RequestMethod.POST)
	public @ResponseBody String Product_Select(MultipartHttpServletRequest uploadFile) throws Exception {
		String result = "";
		String f_realname = "";
		String path = "C:\\Users\\Playdata\\git\\Encore_1jooo\\AcodaProject\\WebContent\\img\\"; // 파일 저장경로
		File dir = new File(path);
		if (!dir.isDirectory()) {
			dir.mkdir();
		}

		Iterator<String> files = uploadFile.getFileNames();
		while (files.hasNext()) {
			String upload = files.next();
			MultipartFile mult = uploadFile.getFile(upload);
			f_realname = mult.getOriginalFilename();
			System.out.println("리얼네임은 :" + f_realname);

			mult.transferTo(new File(path + f_realname));
		}
		result = path + f_realname;
		return result;

	}

}
