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
<title>가이드 신청서 확인</title>
</head>
<body>
<%MemberVO vo = (MemberVO) session.getAttribute("login");%>

	<table border="1">
		<thead style="text-align: center;">
			<tr>
				<th>신청인 아이디</th>
				<th>신청서</th>
				
			</tr>
		</thead>
		<tbody style="text-align: left;">
			<c:forEach var="BuyList" items="${requestScope.list}">
				<tr>
					<td><c:out value="${list.order_number}" /></td>
					<!-- 구매자 아이디 -->
					<td><a href="click.do?click_number=${list.order_number}">
					<c:out value="${list.id}" /></a></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${vo.rating==2 }">
		<td><a href="delete.do?del_number=${list.order_number}">거부
		</a></td>
		<td><a href="find.do?find_number=${list.order_number}">승락</a></td>
	</c:if>

</body>
</html>