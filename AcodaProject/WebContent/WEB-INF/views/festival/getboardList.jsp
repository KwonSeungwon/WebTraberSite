	<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.*,com.acoda.vo.*" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글목록</title>
</head>
<body>
	<h3>찾는 글 목록</h3>
	<table border="1">
	<thead style="text-align:center;">
		<tr>
			<th>축제글 번호</th><th>축제이름</th><th>계절</th><th>축제 시작일</th><th>축제 마지막일</th><th>장소</th>
		</tr>
	</thead>
	<tbody style="text-align:left;">
	<c:forEach var="fe" items="${requestScope.list}">
		<tr>
			<td><c:out value=" ${fe.f_number}" /></td>
			<td><c:out value=" ${fe.f_name}" /></td>
			<td><c:out value=" ${fe.season}" /></td>
			<td><c:out value=" ${fe.f_start_date}" /></td>
			<td><c:out value=" ${fe.f_end_date }" /></td>
			<td><c:out value=" ${fe.f_local}" /></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	
	<a href="/AcodaProject/festival/select.do">축제게시판으로</a>
	<a href="/AcodaProject/index.jsp">메인페이지로</a>
	
</body>
</html>