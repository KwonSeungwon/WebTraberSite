<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.acoda.vo.*" %>
<%
              List<Post_BoardVO> all = (List<Post_BoardVO>)request.getAttribute("click");
              MemberVO vo = (MemberVO) session.getAttribute("login");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>게시글 클릭</title>
</head>
<body>
<%= session.getAttribute("login") %>
<table border="1">
	<c:forEach var="se" items="${requestScope.click}">
		<tr>
			<th>글번호</th><th><c:out value="${se.post_number}"/></th>
		</tr>
		<tr>
			<th>아이디</th><th><c:out value="${se.id}"/></th>
		</tr>
		<tr>
			<th>제목</th><th><c:out value="${se.post_title}"/></th>
		</tr>
		<tr>
			<th>내용</th><th><c:out value="${se.post_contents}"/></th>
		</tr>
		<tr>
			<th>등록일</th><th><c:out value="${se.registration_date}"/></th>
		</tr>
		<tr>
			<th>조회수</th><th><c:out value="${se.views}"/></th>
		</tr>
		<tr>
			<th>사진경로</th><th><c:out value="${se.path}"/></th>
		</tr>

	</c:forEach>
</table>

<a href="/AcodaProject/index.jsp">메인페이지로</a>

</body>
</html>