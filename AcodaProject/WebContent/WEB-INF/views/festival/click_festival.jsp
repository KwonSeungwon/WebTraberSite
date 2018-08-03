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
<table border="1">
	<c:forEach var="fe" items="${requestScope.click}">
			<tr>
				<th>축제글번호</th><th><c:out value=" ${fe.f_number}"/></th>
			</tr>
			<tr>
				<th>축제이름</th><th><c:out value=" ${fe.f_name}"/></th>
			</tr>
			<tr>	
				<th>계절</th><th><c:out value=" ${fe.season}"/></th>
			</tr>	
			<tr>	
				<th>축제 시작일</th><th><c:out value=" ${fe.f_start_date}"/></th>
			</tr>	
			<tr>	
				<th>축제 마지막일</th><th><c:out value=" ${fe.f_end_date }"/></th>
			</tr>
			<tr>	
				<th>장소</th><th><c:out value=" ${fe.f_local}"/></th>
			</tr>
			<tr>	
				<th>내용</th><th><c:out value=" ${fe.f_contents}"/></th>
			</tr>
	</c:forEach>
</table>
  <a href="/AcodaProject/festival/select.do">축제글 보기</a>
<a href="/AcodaProject/index.jsp">메인페이지로</a>
</body>
</html>