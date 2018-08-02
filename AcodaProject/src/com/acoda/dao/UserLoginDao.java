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
		int count = sqlSession.selectOne("logidncheck", vo);			
		System.out.println(count);
			if (count == 0) {
				result = 0;
			} else {
				result = 1;
			}

		return result;

	}

	public MemberVO LoginCheck2(MemberVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return vo = sqlSession.selectOne("LoginUserView",vo);
	
	}

}
