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
import com.acoda.vo.ProductVO;

@Repository
public class BuyDAO implements IBuy {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<BuyVO> getAllBuy(int unumber) {

		RowMapper<BuyVO> mapper = new RowMapper<BuyVO>() {

			@Override
			public BuyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BuyVO vo = new BuyVO();
				vo.setItem_number(rs.getInt("item_number"));
				vo.setOrder_number(rs.getInt("order_number"));
				vo.setOrder_day(rs.getString("order_day"));
				vo.setNationality(rs.getString("nationality"));
				vo.setFellow_traveler(rs.getInt("fellow_traveler"));
				vo.setLanguage(rs.getString("language"));
				vo.setUnusual(rs.getString("unusual"));
				vo.setApplication(rs.getString("application"));
				vo.setMemo(rs.getString("memo"));
				//vo.setUser_number(rs.getInt("user_number"));
				return vo;
			}
		};
		return jdbcTemplate.query(select_buy, mapper, new Object[] { unumber });

	}
	//신청서 확인(가이드 )
	public List<BuyVO> getApllication_list(int a) {
		RowMapper<BuyVO> mapper=new RowMapper<BuyVO>() {
			
			@Override
			public BuyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BuyVO vo = new BuyVO();
				
				vo.setId(rs.getString("id"));
				vo.setOrder_number(rs.getInt("order_number"));
				vo.setOrder_day(rs.getString("order_day"));
				vo.setNationality(rs.getString("nationality"));
				vo.setFellow_traveler(rs.getInt("fellow_traveler"));
				vo.setLanguage(rs.getString("language"));
				vo.setUnusual(rs.getString("unusual"));
				//vo.setItem_number(rs.getInt("item_number"));
				//vo.setUser_number(rs.getInt("user_number"));
				return vo;
			}
		};
		return jdbcTemplate.query(a_select_buy, mapper,new Object[] {a});
	}
	
	public int getDelBuy(int order_number) {

		int b_del = jdbcTemplate.update(delete_buy,order_number);

		return b_del;

	}

	public int getInsertBuy(BuyVO vo) {

		int b = jdbcTemplate.update(insert_buy,new Object[] {vo.getOrder_day(),vo.getNationality(),vo.getFellow_traveler(),vo.getLanguage(),
						 vo.getUnusual(), vo.getUser_number(),vo.getItem_number()});
		System.out.println("여기는 dao 인서트"+b);
		if (b > 0) {
			return b;
		} else {
			return 0;
			}
		}

	
	public BuyVO getFindBuy(String fine_buy) {
		return null;

	}	
	//신청서 업데이트 (결과와 거절시 이유)
	public int geta_UpdateBuy(BuyVO vo) {
		/*BuyVO vo=new BuyVO();*/
		int b = jdbcTemplate.update(update_buy,new Object[]{vo.getApplication(),vo.getMemo(),vo.getOrder_number()});
		System.out.println(b);
	System.out.println(vo.getApplication());
	System.out.println(vo.getMemo());

	
		return b;
	}


}
