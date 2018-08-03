<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.acoda.vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품게시</title>
</head>
<body>
	<h2>상품</h2>
	<c:set var="vo" value="${sessionScope.login}" />
	<h1>
		<c:out value=" ${vo.rating}" />
	</h1>
	<table border="1">
		<thead style="text-align: center;">
			<tr>
				<th>상품번호</th>
				<th>상품이름</th>
				<th>id</th>
				<th>가격</th>
				<th>수용인원</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody style="text-align: left;">
			<c:forEach var="pr" items="${requestScope.list}">
				<tr>
					<td><c:out value="${pr.item_number}" /></td>

					<td><a href="productdetail.do?item_number=${pr.item_number}">
					<c:out value="${pr.product_name}" /></a></td>

					<td><c:out value="${pr.id}" /></td>
					<td><c:out value="${pr.price}" /></td>
					<td><c:out value="${pr.head_count}" /></td>
					
					<td><c:out value="${pr.sell_date}" /></td>
					<%--<td><c:out value="${pr.schedule}"/></td>
					<td><c:out value="${pr.trip_date}"/></td> 
					<td><c:out value="${pr.note}"/></td>  --%>
					<c:if test="${vo.id == pr.id || vo.rating==3}">
					<td><a href="delete.do?del_number=${pr.item_number}">삭제 </a></td>
					</c:if>
					<c:if test="${vo.id == pr.id }">
					<td><input type = "button" value = "수정하기" onclick="location.href='pupinfo.do?item_number=${pr.item_number}'"></td>
					</c:if>
					<td><a href="">신청서 확인 </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="search.do" method="get">
		<table border="1" cellpadding="0" cellspacing="0" width="600">
			<tr>
				<td align="center"><select name="searchCondition">
						<option value="title">제목
				</select> <input name="searchkeyword" type="text" id="searchkeyword" /> <input
					type="submit" value="검색" /></td>
			</tr>
		</table>
	</form>
	<c:if test="${vo.rating==2}">
		<a href="/AcodaProject/input/input_product.jsp">상품 등록</a>
	</c:if>
	<a href="/AcodaProject/index.jsp">메인페이지로</a>

</body>
</html>