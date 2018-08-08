<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body style="font-size: 2.0em; margin: 150px 150px 150px 150px;">
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>아이템번호</th>
			<th>주문번호</th>
			<th>주문날짜</th>
			<th>국적</th>
			<th>인원</th>
			<th>사용언어</th>
			<th>기타사항</th>
			<th>신청서 결과</th>
			<th>메세지</th>
		</tr>
		<c:forEach items="${BuyList}" var="BuyList">
			<tr>
				<td>${BuyList.item_number}</td>
				<td>${BuyList.order_number}</td>
				<td>${BuyList.order_day}</td>
				<td>${BuyList.nationality}</td>
				<td>${BuyList.fellow_traveler}</td>
				<td>${BuyList.language}</td>
				<td>${BuyList.unusual}</td>
				<td>${BuyList.application}</td>
				<td>${BuyList.memo}</td>
				<c:if test="${BuyList.application =='reject'}">
				<td><a href="delorder.do?del_ordernum=${BuyList.order_number}">삭제</a></td>
				<%-- <td><a  href ="deleteorder.do?del_ordernum=${BuyList.order_number}"> 삭제  </a></td> --%>
			</c:if>
			</tr>
		</c:forEach>
		</table>
		<a href="/AcodaProject/index.jsp">홈 화면으로 이동</a>
		<div align="center"></div>

</body>
</html>