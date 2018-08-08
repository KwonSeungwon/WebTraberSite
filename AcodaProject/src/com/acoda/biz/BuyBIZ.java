package com.acoda.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acoda.dao.BuyDAO;
import com.acoda.vo.BuyVO;

@Service
public class BuyBIZ {

	@Autowired
	BuyDAO buyDAO;
	
	public int getInsertBuy(BuyVO vo) {
		return buyDAO.getInsertBuy(vo);
		
	}
	
	public BuyVO getFindBuy(String name) {
		return null;
		
	}
	
	
	public int getUpdateBuy(BuyVO vo) {
		return 0;
	}

	public List<BuyVO> BuyAllSelectBiz(int unumber) {
		
		return buyDAO.getAllBuy(unumber);
	}

	public int getDelBuy(int order_number) {
		return buyDAO.getDelBuy(order_number);

	}
	//신청서 목록 보여주는 비즈
	public List<BuyVO> getApllication_list(int a){
		return  buyDAO.getApllication_list(a);
		
	}
	//신청서의 승낙여부를 업데이트 하는 업데이트문
	public int geta_UpdateBuy(BuyVO vo) {
	
		return buyDAO.geta_UpdateBuy(vo);
		
	}
	
}
