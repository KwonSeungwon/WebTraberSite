package com.acoda.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.acoda.vo.MemberVO;

public class UserInfoDao {

/*	@Autowired
	private SqlSessionFactory factory; // springmvc 마이바티스 id와 매핑(변수명을)
	private SqlSession sqlsession;

	public List<MemberVO> select() {
		List<MemberVO> list = null;
		try (SqlSession session = factory.openSession()) {
			list = session.selectList("userInfo.selectalluser");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public String insertUser(MemberVO vo) {
		String result = "";
		try (SqlSession session = factory.openSession()) {
			int n = session.insert("userInfo.insertUser", vo);
			System.out.println("다오도착");
			if (n > 0) {
				result = vo.getId();
				System.out.println("데이터 저장이 완료됨.");
				session.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public int DeleteUser(MemberVO vo) {
		try (SqlSession session = factory.openSession()) {
			int n = session.delete("userInfo.deleteUser", vo);
			System.out.println("삭제다오도착");
			if (n > 0) {
				System.out.println("데이터 삭제 완료.");
				session.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public int UpdateUser(MemberVO vo) {
		try (SqlSession session = factory.openSession()) {
			int n = session.update("userInfo.updateUser", vo);
			System.out.println("수정다오도착");
			if (n > 0) {
				System.out.println("데이터 수정 완료.");
				session.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public boolean logincheck(MemberVO vo) {
		System.out.println("로그인 체크 다오");
		int count = Integer.parseInt(sqlsession.selectOne("userInfo.check", vo).toString()),
				totalCount = sqlsession.selectOne("userInfo.totalcount");

		if (totalCount > 0) {
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		}

		return false;

	}*/

}
