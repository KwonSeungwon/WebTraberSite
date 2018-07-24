package com.acoda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.acoda.vo.BuyVO;

@Repository
public class BuyDAO implements IBuy {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<BuyVO> getAllBuy(){
		return null;
		
	}
	
	public int getDelBuy() {
		return 0;
		
	}
	
	public int getInsertBuy(BuyVO vo) {
		return 0;
		
	}
	
	public BuyVO getFindBuy(String fine_buy) {
		return null;
		
	}
	
	public int getUpdateBuy(BuyVO vo) {
		return 0;
	}
	
	
	
	
}
