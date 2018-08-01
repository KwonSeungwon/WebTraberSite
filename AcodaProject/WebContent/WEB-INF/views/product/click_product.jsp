<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.util.*,com.acoda.vo.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 보기</title>
</head>
<body>
	<%
		MemberVO vo = (MemberVO) session.getAttribute("login");
	%>
	<c:set var="vo"  value="${sessionScope.login}"/>
<table border="1">
			<tr>
				<th>상품번호</th><th><c:out value=" ${item_number}"/></th>
			</tr>
			<tr>
				<th>상품이름</th><th><c:out value=" ${product_name}"/></th>
			</tr>
			<tr>	
				<th>가격</th><th><c:out value=" ${price}"/></th>
			</tr>	
			<tr>	
				<th>수용인원</th><th><c:out value=" ${head_count}"/></th>
			</tr>	
			<tr>	
				<th>등록일</th><th><c:out value=" ${sell_date}"/></th>
			</tr>
			<tr>	
				<th>상세일정</th><th><c:out value=" ${schedule}"/></th>
			</tr>
			<tr>	
				<th>가이드 날짜</th><th><c:out value=" ${trip_date}"/></th>
			</tr>
			<tr>	
				<th>참고사항</th><th><c:out value=" ${note}"/></th>
			</tr>

</table>
		
 	<a href="/AcodaProject/product/select.do">상품 게시목록</a>
 	<a href="/AcodaProject/application_form.jsp">구매 신청</a>
	<a href="/AcodaProject/index.jsp">메인페이지로</a>
</body>
</html>