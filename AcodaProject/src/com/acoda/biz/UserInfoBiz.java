package com.acoda.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.acoda.vo.MemberVO;


public class UserInfoBiz {

	
	
	@Autowired
	private UserInfoDao userDao;
	
	public List<MemberVo> select() {
		return UserDao.select();
	}

	public String insert(MemberVo vo) {
		System.out.println("인서트비즈도착");
		return UserDao.insertUser(vo);
	}

	public int delete(MemberVo vo) {
		System.out.println("딜리트비즈도착");
		return userDao.DeleteUser(vo);
	}

	public int update(MemberVo vo) {
		System.out.println("업데이트");
		return userDao.UpdateUser(vo);
	}
	



	public boolean logincheck(UserInfo vo) {
		System.out.println("로그인체크비즈");
		return userDao.logincheck(vo);
	}
}
}
