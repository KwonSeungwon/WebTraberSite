package com.acoda.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.acoda.biz.BuyBIZ;
import com.acoda.vo.BuyVO;
import com.acoda.vo.FestivalVO;
import com.acoda.vo.MemberVO;

@Repository
public class BuyDAO implements IBuy {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<BuyVO> getAllBuy(int unumber) {
		
		RowMapper<BuyVO> mapper=new RowMapper<BuyVO>() {
		
			@Override
			public BuyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BuyVO vo = new BuyVO();
				vo.setItem_number(rs.getInt("ITEM_NUMBER"));
				vo.setUser_number(rs.getInt("USER_NUMBER"));
				vo.setOrder_number(rs.getInt("ORDER_NUMBER"));
				vo.setOrder_day(rs.getString("ORDER_DAY"));
				vo.setNationality(rs.getString("NATIONALITY"));
				vo.setFellow_traveler(rs.getInt("FELLOW_TRAVELER"));
				vo.setLanguage(rs.getString("LANGUAGE"));
				vo.setUnusual(rs.getString("UNUSAL"));
				return vo;
			}
		};
		return jdbcTemplate.query(select_buy, mapper, new Object[] {unumber});

	}

	public int getDelBuy(int itemnum) {
		
		int d_result = jdbcTemplate.update(delete_buy,itemnum);
		
		return d_result;

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
