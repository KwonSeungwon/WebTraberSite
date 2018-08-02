<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import="java.util.*,com.acoda.vo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="vo"  value="${sessionScope.login}"/>
	<h3>찾는 글 목록</h3>
	<table border="1">
	<thead style="text-align:center;">
		<tr>
			<th>상품 번호</th><th>상품 이름</th><th>id</th><th>가격</th><th>수용인원</th><th>등록일</th>
		</tr>
	</thead>
	<tbody style="text-align:left;">
	<c:forEach var="pv" items="${requestScope.pvo}">
		<tr>
			<td><c:out value=" ${pv.item_number}" /></td>
			<td><a href ="#"><c:out value=" ${pv.product_name}" /></a></td>
			<td><c:out value=" ${pv.id}" /></td>
			<td><c:out value=" ${pv.price}" /></td>
			<td><c:out value=" ${pv.head_count}" /></td>
			<td><c:out value=" ${pv.sell_date}" /></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	
	<a href="/AcodaProject/product/select.do">상품 목록</a>
	<a href="/AcodaProject/index.jsp">메인페이지로</a>
	
</body>
</html>