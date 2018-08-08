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
<!-- <script type="text/javascript">
	$(document).ready(function() {
		$(document).ready(function() {
			alert("처리되었습니다.");
			location.href = "../index.jsp";

		});
	});
</script> -->
<script type="text/javascript">
$(document).ready(function() {
	$(document).submit(function() {
		
		
	});
});
</script>
<body>
	<h2>신청서 확인는 페이지</h2>
	<c:set var="vo" value="${sessionScope.login}" />
	<h1>
		<c:out value=" ${vo.rating}" />
	</h1>
	<form action="/AcodaProject/buy/application_update.do"  method="post" >
<%--<form action="/AcodaProject/buy/application_update.do?order_number=${list.order_number}&item_number=${list.item_number}" method="post">
 --%>		<table border="1">

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
					<th>메모(거절 이유 작성)</th>
					</tr>
			</thead>
			<tbody style="text-align: left;">
<%-- 
			<c:if test="${item_number == pr.item_number}">  --%>
					<c:forEach var="bu" items="${list}" varStatus="i">
					
						<tr>
							<td>신청서</td>
							<td><c:out value=" ${bu.id}" /></td>
							<td><c:out value=" ${bu.order_day}" /></td>
							<%-- <td><c:out value="${pr.product_name}"/></td> --%>
							<td><c:out value=" ${bu.nationality}"   /></td>
							<td><c:out value=" ${bu.fellow_traveler}" /></td>
							<td><c:out value=" ${bu.language}" /></td>
							<td><c:out value=" ${bu.unusual}" /></td>
							
							<td><select name="application">
								<option value="ok">승인
								<option value="reject">거절
								
							</select></td>
							<td><textarea name="memo"></textarea> 
				
						</tr>
		<input type="hidden" name="order_number" value="${bu.order_number}">
					</c:forEach>
			<%--  </c:if>  --%>

			</tbody>
		</table>
		<input  type="submit" value="보내기" />
	</form>
	<a href="/AcodaProject/product/select.do">상품 게시목록</a>
	<a href="/AcodaProject/index.jsp">메인페이지로</a>

</body>
</html>