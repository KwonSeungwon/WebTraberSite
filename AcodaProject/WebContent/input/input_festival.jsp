<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>축제글 추가 게시판</title>
</head>
<body>
<%=session.getAttribute("login") %>
여기는 관리자가 축제 정보를 올리는 게시판입니다. <br><br><hr>
<form action=" /AcodaProject/festival/insert.do" method="get">

이름 <input type="text" name="f_name"><br>
계절<input type="text"  name="season"><br>
시작일 <input type="text" name="f_start_date">~
마지막일<input type="text" name="f_end_date">
장소<input type="text" name="f_local"><br>
내용<input type="text" name="f_contents"><br>
회원고유번호<input type="text" name="user_number">

    <input type="submit" value="등록" />
       <input type="reset" value="취소 "/>

</form>
<a href="/AcodaProject/festival/select.do">축제글 목록</a>
<a href ="/AcodaProject/index.jsp">홈으로</a>
</body>
</html>