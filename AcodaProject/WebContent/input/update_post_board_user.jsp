<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.acoda.vo.MemberVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>유저업데이트</title>
</head>
<body>
<%MemberVO vo = (MemberVO)session.getAttribute("login"); %>
<%
 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 String today = formatter.format(new java.util.Date());
%>
<form action="/AcodaProject/post_board/update_user.do" method="POST">
유저게시판 게시글수정<br><br>

<!-- 회원고유번호 : 히든처리 -->
<input type="hidden" name="user_number" value="<%=vo.getUser_number()%>"/>
<!-- 게시글번호(P) : 히든처리  -->
<input type="hidden" name="post_number" value="${find.post_number}"/><br>
게시글제목 : <input type="text" name="post_title" value="${find.post_title}"/><br>
게시글내용 : <input type="text" name="post_contents" value="${find.post_contents}"/><br>
<!-- 등록일자 : 히든처리 --><input type="hidden" name="registration_date" value="<%=today.toString()%>"/>
<!-- 조회수 : <input type="text" name="views"/><br> -->
사진파일경로 : <input type="text" name="path"/><br>	
		<input type="submit" value="확인 "/>
       <input type="reset" value="취소 "/>
       
</form>
<a href="/AcodaProject/post_board/select_user.do">유저게시판으로 돌아가기</a><br>
<a href="/AcodaProject/index.jsp">홈으로</a>
</body>
</html>