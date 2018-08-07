package com.acoda.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;




import com.acoda.vo.FestivalVO;
import com.acoda.vo.BuyVO;
import com.acoda.vo.ProductVO;

@Repository
public class ProductDAO implements IProduct {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<ProductVO> getAllProduct() {
		List<ProductVO> list = jdbcTemplate.query(select_product, new RowMapper<ProductVO>() {

			@Override
			public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductVO pvo = new ProductVO();
				pvo.setItem_number(rs.getInt("item_number"));
				pvo.setProduct_name(rs.getString("product_name"));
				pvo.setId(rs.getString("id"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setHead_count(rs.getInt("head_count"));
				pvo.setSell_date(rs.getString("sell_date"));
				pvo.setSchedule(rs.getString("schedule"));
				pvo.setTrip_date(rs.getString("trip_date"));
				pvo.setNote(rs.getString("note"));
				pvo.setPic(rs.getString("pic"));
				return pvo;
			}
		});
		return list;

	}

	public int getDelProduct(String name) {
		int p = jdbcTemplate.update(delete_product, name);
		return p;

	}

	// 상품추가
	public int getInsertProduct(ProductVO vo) {
		System.out.println("상품 추가 다오");

		int p = jdbcTemplate.update(insert_product,
				new Object[] { vo.getProduct_name(), vo.getUser_number(), vo.getPrice(), vo.getHead_count(),
						vo.getSell_date(), vo.getSchedule(), vo.getTrip_date(), vo.getNote(), vo.getPic() });
		if (p > 0) {
			return p;
		} else {
			return 0;
		}
	}

	// 클릭
	public List<ProductVO> getClickProduct(int number) {
		RowMapper<ProductVO> mapper = new RowMapper<ProductVO>() {

			@Override
			public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductVO pvo = new ProductVO();
				pvo.setItem_number(rs.getInt("item_number"));
				pvo.setProduct_name(rs.getString("product_name"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setHead_count(rs.getInt("head_count"));
				pvo.setSell_date(rs.getString("sell_date"));
				pvo.setSchedule(rs.getString("schedule"));
				pvo.setTrip_date(rs.getString("trip_date"));
				pvo.setNote(rs.getString("note"));
				return pvo;
			}
		};
		return jdbcTemplate.query(click_product, mapper, new Object[] { number });
	}

	// 검색
	public List<ProductVO> getSearch_product(String name) {
		System.out.println("상품검색 다오" + name.toString());
		RowMapper<ProductVO> mapper = new RowMapper<ProductVO>() {

			@Override
			public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductVO pvo = new ProductVO();

				pvo.setItem_number(rs.getInt("item_number"));
				pvo.setProduct_name(rs.getString("product_name"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setId(rs.getString("id"));
				pvo.setHead_count(rs.getInt("head_count"));
				pvo.setSell_date(rs.getString("sell_date"));
				pvo.setTrip_date(rs.getString("trip_date"));
				return pvo;
			}
		};
		return jdbcTemplate.query(search_product, mapper, new Object[] { name });
	}

	public ProductVO getFindProduct(String find_product) {
		return null;

	}

	public int getUpdateProduct(ProductVO vo) {

		int f = jdbcTemplate.update(update_product,
				new Object[] { vo.getProduct_name(), vo.getUser_number(), vo.getPrice(), vo.getHead_count(),
						vo.getSell_date(), vo.getSchedule(), vo.getTrip_date(), vo.getNote(), vo.getPic(),
						vo.getItem_number() });
		System.out.println("여기는 다오 업데이트-->" + f);
		if (f > 0) {
			System.out.println("성공");
			return f;
		} else {
			System.out.println("실패");
			return 0;
		}
	}

	public ProductVO getDetailinfo(int item_num) {
		RowMapper<ProductVO> mapper = new RowMapper<ProductVO>() {

			@Override
			public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductVO pvo = new ProductVO();
				pvo.setItem_number(rs.getInt("item_number"));
				pvo.setProduct_name(rs.getString("product_name"));
				pvo.setId(rs.getString("id"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setHead_count(rs.getInt("head_count"));
				pvo.setSell_date(rs.getString("sell_date"));
				pvo.setSchedule(rs.getString("schedule"));
				pvo.setTrip_date(rs.getString("trip_date"));
				pvo.setNote(rs.getString("note"));
				pvo.setPic(rs.getString("pic"));
				return pvo;
			}
		};
		return jdbcTemplate.queryForObject(select_detail, mapper, item_num);

	}

	public ProductVO getupdateinfo(int num) {
		RowMapper<ProductVO> mapper=new RowMapper<ProductVO>() {
			
	
		@Override
		public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProductVO pvo=new ProductVO();
			pvo.setItem_number(rs.getInt("item_number"));
			pvo.setProduct_name(rs.getString("product_name"));
			pvo.setId(rs.getString("user_number"));
			pvo.setPrice(rs.getInt("price"));
			pvo.setHead_count(rs.getInt("head_count"));
			pvo.setSell_date(rs.getString("sell_date"));
			pvo.setSchedule(rs.getString("schedule"));
			pvo.setTrip_date(rs.getString("trip_date"));
			pvo.setNote(rs.getString("note"));
			pvo.setPic(rs.getString("pic"));
		

		return pvo;

		}
	};
	return jdbcTemplate.queryForObject(productupdateinfo, mapper,num);
	
		}
}
