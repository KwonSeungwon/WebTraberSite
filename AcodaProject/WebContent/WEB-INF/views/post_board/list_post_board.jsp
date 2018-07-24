<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.acoda.vo.*" %>
<%
              List<Post_BoardVO> all = (List<Post_BoardVO>)request.getAttribute("all");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>게시판 출력</title>
</head>
<body>
<%= session.getAttribute("login") %>
<table border="1">
	<thead style="text-align:center;">
		<tr>
			<th>게시글번호</th><th>게시판이름</th><th>작성자</th><th>게시글제목</th><th>작성일</th><th>조회수</th>
		</tr>
	</thead>
	<tbody style="text-align:left;">
		<c:forEach var="se" items="${requestScope.all }">
			<tr>
				<td><c:out value="${se.post_number}"/></td>
				<td><c:out value="${se.title}"/></td>
				<td><c:out value="${se.id}"/></td>
				<td><a href="#"><c:out value="${se.post_title}"/></a></td>
				<td><c:out value="${se.registration_date}"/></td>
				<td><c:out value="${se.views}"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/AcodaProject/insert_page.do">게시글작성</a>
<a href="index.jsp">메인페이지로</a>

</body>
</html>