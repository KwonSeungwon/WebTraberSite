<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*,com.acoda.vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>축제글 추가 게시판</title>
</head>
<body>
 <%
      MemberVO vo = (MemberVO) session.getAttribute("login");
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String today = sdf.format(new Date());
   %>
여기는 관리자가 축제 정보를 올리는 게시판입니다. <br><br><hr>
<form action=" /AcodaProject/festival/insert.do" method="get">

이름 <input type="text" name="f_name" required=""><br>
계절<input type="text"  name="season" required="" ><br>
시작일 <input type="date" name="f_start_date" required="">~
마지막일<input type="date" name="f_end_date" required="">
장소<input type="text" name="f_local" required=""><br>
내용<textarea rows="2" cols="30" name="f_contents" required=""></textarea><br>
<input type="hidden" name="user_number" value=<%=vo.getUser_number()%>>

    <input type="submit" value="등록" />
       <input type="button" value="취소 " onclick="location.href='/AcodaProject/festival/select.do'"/>

</form>
<!-- <a href="/AcodaProject/festival/select.do">축제글 목록</a> -->
<a href ="/AcodaProject/index.jsp">홈으로</a>
</body>
</html>