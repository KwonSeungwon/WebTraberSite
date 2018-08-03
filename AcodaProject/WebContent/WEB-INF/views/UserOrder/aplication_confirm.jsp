<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.acoda.vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".sbtn").click(function() {
		alert("처리되었습니다.");
		location.href = "../index.jsp";
		
		});
	});
</script>
<body>
	<h2>신청서 확인는 페이지</h2>
	<c:set var="vo" value="${sessionScope.login}" />
	<h1>
		<c:out value=" ${vo.rating}" />
	</h1>

	<table border="1">

		<thead style="text-align: center;">
			<tr>
				<th>신청서</th>
				<th>id</th>
				<th>주문날짜</th>
				<!-- <th>상품 이름 </th> -->
				<th>국적</th>
				<th>동행인원</th>
				<th>언어</th>
				<th>참고사항</th>
				<th>승인/거절</th>
			</tr>
		</thead>
		<tbody style="text-align: left;">

			<c:if test="${bu.item_number == pr.item_number}">
				<c:forEach var="bu" items="${list}">
					<tr>
						<td><a href="a_f.do?a_f=${bu.order_number}">신청서</a></td>
						<td><c:out value=" ${bu.id}" /></td>
						<td><c:out value=" ${bu.order_day}" /></td>
						<%-- <td><c:out value="${pr.product_name}"/></td> --%>
						<td><c:out value=" ${bu.nationality}" /></td>
						<td><c:out value=" ${bu.fellow_traveler}" /></td>
						<td><c:out value=" ${bu.language}" /></td>
						<td><c:out value=" ${bu.unusual}" /></td>
						<td><select name="searchCondition">
								<option value="ok">승인
								<option value="reject">거절
						</select></td>

					</tr>

				</c:forEach>
			</c:if>

		</tbody>
	</table>

	<input type="button" value="보내기" class = "sbtn" />



</body>
</html>