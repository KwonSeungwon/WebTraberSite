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
	private SqlSessionFactory sqlSessionFactory;

	public int LoginCheck(MemberVO vo) {

		int result = 0;
		System.out.println("로그인체크다오");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int count = Integer.parseInt(sqlSession.selectOne("logidncheck", vo).toString()),
				totalcount = sqlSession.selectOne("totalAcount");
		System.out.println(count);

		if (totalcount > 0) {
			if (count > 0) {
				result = 0;
				sqlSession.commit();
				sqlSession.close();
			} else {
				result = 1;
				sqlSession.commit();
				sqlSession.close();
			}
		}

		return result;

	}

}
