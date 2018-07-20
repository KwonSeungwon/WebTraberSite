package com.acoda.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.acoda.dao.UserInfoDao;
import com.acoda.vo.MemberVO;

public class UserInfoBiz {

	@Autowired
	private UserInfoDao UserDao;

	public List<MemberVO> select() {
		return UserDao.select();
	}

	public String insert(MemberVO vo) {
		System.out.println("인서트비즈도착");
		return UserDao.insertUser(vo);
	}

	public int delete(MemberVO vo) {
		System.out.println("딜리트비즈도착");
		return UserDao.DeleteUser(vo);
	}

	public int update(MemberVO vo) {
		System.out.println("업데이트");
		return UserDao.UpdateUser(vo);
	}

	public boolean logincheck(MemberVO vo) {
		System.out.println("로그인체크비즈");
		return UserDao.logincheck(vo);
	}
}
