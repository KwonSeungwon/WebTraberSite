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

	public int insertNomalUser(MemberVO vo) {
		int n = 0 ;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			n = session.insert("userInfo.insertNomal", vo);
			System.out.println("다오도착");
			if (n > 0) {
				System.out.println("데이터 저장이 완료됨.");
				session.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;

	}

	public int insertUser(MemberVO vo) {
		int n = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			n = session.insert("userInfo.insertGuide", vo);
			System.out.println("다오도착");
			if (n > 0) {
				System.out.println("데이터 저장이 완료됨.");
				session.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;

	}

	public int DeleteUser(MemberVO vo) {
		int n = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			n = session.delete("userInfo.deleteUser", vo);
			System.out.println("삭제다오도착");
			if (n > 0) {
				System.out.println("데이터 삭제 완료.");
				session.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;

	}

	public boolean IdCheck(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int count = sqlSession.selectOne("userInfo.idcount", id);
		System.out.println(count);
		if (count == 0) {
			sqlSession.commit();
			sqlSession.close();
			return true;
		} else {
			sqlSession.commit();
			sqlSession.close();
			return false;
		}
	}

	public int UpdateGuide(MemberVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.update("userInfo.updateGuideUser", vo);
		System.out.println(result);

		if (result > 0) {
			System.out.println("가이드 수정완료");
			sqlSession.commit();
			sqlSession.close();
		}

		return result;
	}

	public int UpdateNomal(MemberVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.update("userInfo.updateNomalUser", vo);
		if (result > 0) {
			System.out.println("일반유저 수정완료");
			sqlSession.commit();
			sqlSession.close();
		}

		return result;
	}

}
