<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>게시글작성</title>
</head>
<body>
<h3>
<%  String url=request.getContextPath(); %>
<%=session.getAttribute("login") %>

<form action="<%=url%>/post_board/insert.do" method="get">
게시글입력<br><br>

게시판타입번호(F) : <input type="text"  name="p_type"  /><br>
게시판이름 : <input type="text"   name="title"  /><br>
게시판번호 :  <input type="text"   name="title_number"  /><br>
회원고유번호 : <input type="text"  name="user_number" /><br>
게시글번호(P) : <input type="text"  name="post_number"  /><br>
게시글제목 : <input type="text" name="post_title"/><br>
게시글내용 : <input type="text" name="post_contents"/><br>
등록일자 : <input type="text" name="registration_date"/><br>
조회수 : <input type="text" name="views"/><br>
사진파일경로 : <input type="text" name="path"/><br>	
		<input type="submit" value="확인 "/>
       <input type="reset" value="취소 "/>
</form>
</h3>

</body>
</html>