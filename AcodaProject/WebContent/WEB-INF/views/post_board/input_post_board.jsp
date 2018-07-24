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
<form action="<%=url%>/insert_post_board.do" method="get">
게시글입력<br><br>

게시판타입번호(F) : <input type="text"  readonly="readonly" name="post_number"  value='${find.post_number}' /><br>
게시판이름
게시판번호
회원고유번호(F)
게시글번호(P)
게시글제목
게시글내용
등록일자
조회수
사진파일경로

</form>
</h3>

</body>
</html>