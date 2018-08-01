<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.util.*,com.acoda.vo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품게시</title>
</head>
<body>
<h2>상품 </h2>
<c:set var="vo"  value="${sessionScope.login}"/>
<h1><c:out value=" ${vo.rating}"/></h1>
<table border="1">
	<thead style="text-align:center;">
		<tr>
			<th>상품번호</th><th>상품이름</th><th>id</th><th>가격</th><th>수용인원</th><th>등록일</th>
		</tr>
	</thead>
	<tbody style="text-align:left;">
	<c:forEach var="pr" items="${requestScope.list}">
			<tr>
				<td><c:out value="${pr.item_number}"/></td>
				<td><a href="click.do?click_number=pr.item_number"><c:out value="${pr.product_name}"/></a></td>
				<td><c:out value="${pr.id}"/></td>
				<td><c:out value="${pr.price}"/></td>
				<td><c:out value="${pr.head_count}"/></td>
				<td><c:out value="${pr.sell_date}"/></td>
					
				<td> <a  href ="delete.do?del_number=${pr.item_number}">삭제  </a></td>
                <td> <a  href ="find.do?find_number=${pr.item_number}">수정 </a></td> 
			</tr>
			</c:forEach>
			</tbody>
</table>

<a href="/AcodaProject/input/input_product.jsp">상품 등록</a>

<a href="/AcodaProject/index.jsp">메인페이지로</a>

</body>
</html>