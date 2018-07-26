package com.acoda.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acoda.dao.UserInfoDao;
import com.acoda.dao.UserLoginDao;
import com.acoda.vo.MemberVO;

@Service
public class UserInfoBiz {

	@Autowired
	private UserInfoDao UserDao;
	@Autowired
	private UserLoginDao LoginDao;
	

	public List<MemberVO> select() {
		return UserDao.select();
	}

	public String insert(MemberVO vo) {
		System.out.println("인서트비즈도착");
		UserDao.insertUser(vo);
		String guide = "";
		return guide;
	}

	public int delete(MemberVO vo) {
		System.out.println("딜리트비즈도착");
		return UserDao.DeleteUser(vo);
	}

	public int update(MemberVO vo) {
		System.out.println("업데이트");
		return UserDao.UpdateUser(vo);
	}

	public int logincheck(MemberVO vo) {
		System.out.println("로그인체크비즈");
		return LoginDao.LoginCheck(vo);
	}

	public String insertNomal(MemberVO vo) {
		System.out.println("인서트노말비즈도착");
		UserDao.insertNomalUser(vo);	
		String nomal = "";
		return nomal;
	}
	
	public boolean checkId(String id) {
		if(UserDao.IdCheck(id) == true) {
			return true;
		}else { 
			return false;
		}
	}

}
