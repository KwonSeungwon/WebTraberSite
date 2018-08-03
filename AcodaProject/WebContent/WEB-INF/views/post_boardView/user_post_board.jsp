<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.acoda.vo.*" %>
<%@page import="com.acoda.vo.MemberVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
              List<Post_BoardVO> all = (List<Post_BoardVO>)request.getAttribute("all");
              MemberVO vo = (MemberVO) session.getAttribute("login");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>유저게시판 출력</title>
</head>
<body>
<c:set var="vo"  value="${sessionScope.login}" />
로그인 아이디 : <c:out value="${vo.id}"/><br>

<table border="1">
	<thead style="text-align:center;">
		<tr>
			<th>게시글번호</th><th>게시판이름</th><th>작성자</th><th>게시글제목</th><th>작성일</th><th>조회수</th><th>삭제</th><th>수정</th>
		</tr>
	</thead>
	<tbody style="text-align:left;">
		<c:forEach var="se" items="${requestScope.all}">
			<tr>
				<td><c:out value="${se.post_number}"/></td>
				<td><c:out value="${se.title}" /></td>
				<td><c:out value="${se.id}" /></td>
				<td><a href="click.do?click_post_number=${se.post_number}"><c:out value="${se.post_title}"/></a></td>
				<td><c:out value="${se.registration_date}"/></td>
				<td><c:out value="${se.views}"/></td>
					<c:if test="${vo.id==se.id || vo.rating==3}">
				<td><a href ="delete_user.do?del_post_number=${se.post_number}">삭제 </a></td>
           		<td><a href ="find_user.do?find_post_number=${se.post_number}">수정 </a></td>
           			</c:if>
           			
           			
			</tr>
		</c:forEach>
		<c:forEach var="fe" items="${requestScope.list}">
			<tr>
				<td><c:out value="${fe.post_number}"/></td>
				<td><c:out value="${fe.title}"/></td>
				<td><c:out value="${fe.id}"/></td>
				<td><a href="click.do?click_post_number=${fe.post_number}"><c:out value="${fe.post_title}"/></a></td>
				<td><c:out value="${fe.registration_date}"/></td>
				<td><c:out value="${fe.views}"/></td>
				<c:if test="${vo.id==fe.id || vo.rating==3}">
				<td><a href ="delete_user.do?del_post_number=${fe.post_number}">삭제 </a></td>
           		<td><a href ="find_user.do?find_post_number=${fe.post_number}">수정 </a></td>
           		</c:if>
			</tr>
		</c:forEach>
		
		
	</tbody>
</table><br>

<form action="/AcodaProject/post_board/search_user.do" method="get">
	<input name="search_post_board_user" type="text" id="search_post_board_user"/>
	<input type="submit" value="검색"/>
</form>
<a href="/AcodaProject/post_board/insert_user_page.do">유저게시판 글작성하기</a>
<a href="/AcodaProject/index.jsp">메인페이지로</a>

</body>
</html>