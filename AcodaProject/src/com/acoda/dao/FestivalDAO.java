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

	public List<FestivalVO> getAllFestival() {
		List<FestivalVO> all = jdbcTemplate.query(select_festival, new RowMapper<FestivalVO>() {
			@Override
			public FestivalVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				FestivalVO vo = new FestivalVO();
				vo.setTotal(rs.getInt("total"));
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

	// 검색
	public List<FestivalVO> getSearch(String s) {
		RowMapper<FestivalVO> mapper = new RowMapper<FestivalVO>() {

			@Override
			public FestivalVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				FestivalVO vo = new FestivalVO();
				vo.setTotal(rs.getInt("total"));
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
		return jdbcTemplate.query(search_festival, mapper, new Object[] { s ,s});

	}

	// 클릭
	public List<FestivalVO> getClickfestival(String name) {
		System.out.println("클릭 다오" + name);
		// List<FestivalVO> click_list=jdbcTemplate.query(click_festival, new Object[]
		// {f},
		RowMapper<FestivalVO> mapper = new RowMapper<FestivalVO>() {

			@Override
			public FestivalVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				FestivalVO vo = new FestivalVO();
				vo.setF_number(rs.getInt("f_number"));
				vo.setF_name(rs.getString("f_name"));
				vo.setSeason(rs.getString("season"));
				vo.setF_start_date(rs.getString("f_start_date"));
				vo.setF_end_date(rs.getString("f_end_date"));
				vo.setF_local(rs.getString("f_local"));
				vo.setF_contents(rs.getString("f_contents"));
				return vo;
			}
		};

		return jdbcTemplate.query(click_festival, mapper, new Object[] { name });

	}

	public int getInsertFestival(FestivalVO vo) {
		System.out.println("여기는 인서트 다오");
		int f = jdbcTemplate.update(insert_festival, new Object[] { vo.getF_name(), vo.getSeason(),
				vo.getF_start_date(), vo.getF_end_date(), vo.getF_local(), vo.getF_contents(), vo.getUser_number() });

		if (f > 0) {

			return f;
		} else {
			return 0;
		}

	}

	public FestivalVO getFindFestival(String f_number) {
		System.out.println("여기는 파인드 다오" + find_festival);
		System.out.println(f_number+"넘어는 가나?파인드 다오");
		FestivalVO vo = jdbcTemplate.queryForObject(find_festival, new Object[] { f_number },
				new RowMapper<FestivalVO>() {
					@Override
					public FestivalVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						FestivalVO s = new FestivalVO(rs.getInt("f_number"), rs.getString("season"),
								rs.getString("f_name"), rs.getString("f_start_date"), rs.getString("f_end_date"),
								rs.getString("f_local"), rs.getString("f_contents"), rs.getInt("user_number"));
						return s;
					}
				});
		return vo;
	}

	public int getDelFestival(String del_name) {
		int f = jdbcTemplate.update(delete_festival, del_name);

		return f;

	}

	public int getUpdateFestival(FestivalVO vo) {
		System.out.println(vo.getF_number()+"ddddddd");
		int f = jdbcTemplate.update(update_festival, new Object[] {vo.getF_name(),vo.getSeason(),
				vo.getF_start_date(),vo.getF_end_date(),vo.getF_local(),vo.getF_contents(),vo.getF_number()});
		System.out.println("여기는 다오 업데이트-->"+f);
		if (f > 0) {
			System.out.println("성공" + f);
			return f;
		} else {
			System.out.println("실패" + f);
			return 0;
		}
	}

}
