<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.acoda.vo.*" %>
<%
              List<Post_BoardVO> all = (List<Post_BoardVO>)request.getAttribute("all");
              MemberVO vo = (MemberVO) session.getAttribute("login");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>게시글 출력</title>
</head>
<body>
<%= session.getAttribute("login") %>

<table border="1">
	<c:forEach var="se" items="${requestScope.all}">
			<tr>
				<th>게시글 번호 : <c:out value="${se.post_number}"/></th>
				<th>게시판 이름 : <c:out value="${se.title}"/></th>
				<th>게시자 ID : <c:out value="${se.id}"/></th>
				<th>게시글 제목 :<a href="#"><c:out value="${se.post_title}"/></a></th>
				<th>게시글 등록일 :<c:out value="${se.registration_date}"/></th>
				<th>조회수 : <c:out value="${se.views}"/></th>
				<c:set var="id" value="<%=vo.getId()%>">
				<c:if test="${id eq ${se.id}}">
				<th><a href ="delete.do?del_id=${se.id}">삭제 </a></th>
           		<th><a href ="find.do?find_id=${se.id}">수정 </a></th>
           		</c:if></c:set>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/AcodaProject/post_board/insert_user_page.do">유저게시판 게시글작성하기</a>
<a href="index.jsp">메인페이지로</a>

</body>
</html>