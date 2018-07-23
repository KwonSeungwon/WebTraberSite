package com.acoda.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acoda.vo.MemberVO;

@Repository
public class UserLoginDao {

	@Autowired
	private SqlSession sql;
	
	public boolean LoginCheck(MemberVO vo) {
		
		int count = Integer.parseInt(sql.selectOne("logidncheck",vo).toString()),
				totalcount = sql.selectOne("totalAcount");
		
		if(totalcount>0) {
			if(count>0) {
				return true;
			}else {
				return false;
			}
		}
		
		
		return false;
		
	}
	
	
	
	




}
