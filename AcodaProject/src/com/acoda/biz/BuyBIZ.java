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
	
	public List<BuyVO> getAllBuy(){
		return null;
		
	}
	
	public int getInsertBuy(BuyVO vo) {
		return 0;
		
	}
	
	public BuyVO getFindBuy(String name) {
		return null;
		
	}
	
	public int getDelBuy(String del_name) {
		return 0;
		
	}
	
	public int getUpdateBuy(BuyVO vo) {
		return 0;
	}
	

}
