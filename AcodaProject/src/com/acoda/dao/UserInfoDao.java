package com.acoda.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acoda.vo.MemberVO;

@Repository
public class UserInfoDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory; // springmvc 마이바티스 id와 매핑(변수명을)

	public List<MemberVO> select() {
		List<MemberVO> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			list = session.selectList("userInfo.selectalluser");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}
	
	public String insertNomalUser(MemberVO vo) {
		String result = "";
		try (SqlSession session = sqlSessionFactory.openSession()) {
			int n = session.insert("userInfo.insertNomal", vo);
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

	public String insertUser(MemberVO vo) {
		String result = "";
		try (SqlSession session = sqlSessionFactory.openSession()) {
			int n = session.insert("userInfo.insertGuide", vo);
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
		try (SqlSession session = sqlSessionFactory.openSession()) {
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
		try (SqlSession session = sqlSessionFactory.openSession()) {
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

	public int IdCheck(MemberVO vo) {
		int result = 0 ;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int count = Integer.parseInt(sqlSession.selectOne("Idcheck", vo));
		
			if (count > 0) {
				result = 0;
			} else {
				result = 1;
			}
		return result;
	}


}
