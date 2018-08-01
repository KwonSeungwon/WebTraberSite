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
<table border="1">

			<tr>
				<th>상품번호</th><th><c:out value=" ${fe.item_number}"/></th>
			</tr>
			<tr>
				<th>상품이름</th><th><c:out value=" ${fe.product_name}"/></th>
			</tr>
			<tr>	
				<th>가격</th><th><c:out value=" ${fe.season}"/></th>
			</tr>	
			<tr>	
				<th>수용인원</th><th><c:out value=" ${fe.f_start_date}"/></th>
			</tr>	
			<tr>	
				<th>등록일</th><th><c:out value=" ${fe.f_end_date }"/></th>
			</tr>
			<tr>	
				<th>상세일정</th><th><c:out value=" ${fe.f_local}"/></th>
			</tr>
			<tr>	
				<th>가이드 날짜</th><th><c:out value=" ${fe.f_contents}"/></th>
			</tr>
			<tr>	
				<th>참고사항</th><th><c:out value=" ${fe.f_contents}"/></th>
			</tr>

</table>
  <a href="/AcodaProject/product/select.do">상품 게시목록</a>
<a href="/AcodaProject/index.jsp">메인페이지로</a>
</body>
</html>