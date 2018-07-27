<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.acoda.vo.MemberVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>업데이트</title>
</head>
<body>
<% MemberVO vo = (MemberVO) session.getAttribute("login"); %>
<h3>

<%=session.getAttribute("login") %>

<form action="/AcodaProject/post_board/update_user.do" method="get">
후기게시판  게시글수정<br><br>

<!-- 게시판타입번호(F) : <input type="text" name="p_type"/><br>
게시판선택 :<select name="title">
			<option value="">게시판선택</option>
			<option value="유저게시판">유저게시판</option>
			<option value="후기게시판">후기게시판</option>
		</select><br>
게시판번호 :  <input type="text" name="title_number"/><br> -->
회원고유번호 : <input type="text" name="user_number"/><br>
게시글번호(P) : <input type="text" readonly="readonly" name="post_number" value="${find.post_number}"/><br>
게시글제목 : <input type="text" name="post_title"/><br>
게시글내용 : <input type="text" name="post_contents"/><br>
등록일자 : <input type="text" name="registration_date"/><br>
조회수 : <input type="text" name="views"/><br>
사진파일경로 : <input type="text" name="path"/><br>	
		<input type="submit" value="확인 "/>
       <input type="reset" value="취소 "/>
       
</form>
<a href="/AcodaProject/post_board/select_user.do">후기게시판으로 돌아가기</a><br>
<a href="/AcodaProject/index.jsp">홈으로</a>
</h3>

</body>
</html>