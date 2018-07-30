package com.acoda.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.acoda.vo.FestivalVO;

@Repository
public class FestivalDAO implements IFestival {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<FestivalVO> getAllFestival(){
		List<FestivalVO> all=jdbcTemplate.query(select_festival,new RowMapper<FestivalVO>() {
			@Override
			public FestivalVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				FestivalVO vo=new FestivalVO();
				System.out.println(rs.getInt("f_number"));			
				vo.setF_number(rs.getInt("f_number"));
				vo.setF_name(rs.getString("f_name"));
				vo.setSeason(rs.getString("season"));
				vo.setF_start_date(rs.getString("f_start_date"));
				vo.setF_end_date(rs.getString("f_end_date"));
				vo.setF_local(rs.getString("f_local"));
				return vo;
			}
		});
		return all;
		
	}
	//검색
	public List<FestivalVO> getsearch(String s){
		//List<FestivalVO> list=jdbcTemplate.query(se_festival,new Object[] {s},
				System.out.println("여기서 검색");
				System.out.println(s);
				RowMapper<FestivalVO> mapper=new RowMapper<FestivalVO>() {

			@Override
			public FestivalVO mapRow(ResultSet rs, int rowNum) throws SQLException {
					FestivalVO vo=new FestivalVO();
				System.out.println(rs.getInt("f_number"));			
				vo.setF_number(rs.getInt("f_number"));
				vo.setF_name(rs.getString("f_name"));
				vo.setSeason(rs.getString("season"));
				vo.setF_start_date(rs.getString("f_start_date"));
				vo.setF_end_date(rs.getString("f_end_date"));
				vo.setF_local(rs.getString("f_local"));
				return vo;	
			}
		};
		return jdbcTemplate.query(search_festival, mapper, new Object[] {s});
		
	}
	
	public int getDelFestival(String del_name) {
		int f = jdbcTemplate.update(delete_festival,del_name );
		
		return f;
		
	}
	
	public int getInsertFestival(FestivalVO vo) {
		System.out.println("여기는 인서트 다오");
		int f=jdbcTemplate.update(insert_festival,new Object[] 
				{ vo.getF_number(), vo.getF_name(),vo.getSeason(),  vo.getF_start_date(),
                vo.getF_end_date(), vo.getF_local(), vo.getF_contents(), vo.getUser_number()} );
		 
		if (f > 0) {
	         return f;
	      } else {
	         return 0;
	      }
		
	}
	
	public FestivalVO getFindFestival(String find_festival) {
		System.out.println("여기는 파인드 다오"+ find_festival);
	     FestivalVO vo = jdbcTemplate.queryForObject(IFestival.find_festival,new Object[] {find_festival},
	             new RowMapper<FestivalVO>() {
	          @Override
	          public FestivalVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	             FestivalVO s= new FestivalVO(rs.getInt("f_number"),rs.getString("season"),rs.getString("f_name"),rs.getString("f_start_date"),
	                     rs.getString("f_end_date"),rs.getString("f_local"),rs.getString("f_contents"),rs.getInt("user_number"));
	             return s;
	          }
	       });
	       return vo;
	    }
	
	public int getUpdateFestival(FestivalVO vo) {
		int f = jdbcTemplate.update(update_festival, new Object[] {vo.getSeason(),vo.getF_name(),vo.getF_start_date(),
	            vo.getF_end_date(),vo.getF_local(),vo.getF_contents(),vo.getF_number()});
		
		return f;	
	}
	 
}
