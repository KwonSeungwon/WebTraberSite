<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>​
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body style="font-size: 2.0em; margin: 150px 150px 150px 150px;">
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>유저번호</th>
			<th>등급</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>이메일</th>
			<th>가입일</th>
			<th>직업</th>
			<th>생년월일</th>
			<th>프로필</th>
			<th>담당구역</th>
		</tr>
		<c:forEach items="${list}" var="list1">
			<tr>
				<td>${list1.user_number}</td>
				<td>${list1.rating}</td>
				<td>${list1.id}</td>
				<td>${list1.pw}</td>
				<td>${list1.phone}</td>
				<td>${list1.address}</td>
				<td>${list1.email}</td>
				<td>${list1.joindate}</td>
				<td>${list1.job}</td>
				<td>${list1.birth}</td>
				<td>${list1.profile}</td>
				<td>${list1.place}</td>
			</tr>
		</c:forEach>
		</table>
		<a href="/TeamProject/index.html">홈 화면으로 이동</a>

		<div align="center"></div>
</body>
</html>