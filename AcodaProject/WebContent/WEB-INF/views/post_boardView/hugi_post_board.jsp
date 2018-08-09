<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.acoda.vo.*" %>
<%@page import="com.acoda.vo.MemberVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<% 
              List<Post_BoardVO> all = (List<Post_BoardVO>)request.getAttribute("all");
              MemberVO vo = (MemberVO) session.getAttribute("login");
              String searchKeyword = (String)session.getAttribute("searchKeyword");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>후기게시판 출력</title>
</head>
<body>
<c:set var="vo"  value="${sessionScope.login}"/>
로그인 아이디 : <c:out value="${vo.id}"/><br>
<h1>검색어 :<%=searchKeyword%></h1>
<table border="1">
		<tr>
			<th>게시글번호</th><th>게시판이름</th><th>작성자</th><th>게시글제목</th><th>작성일</th><th>조회수</th><th>삭제</th><th>수정</th>
		</tr>
	<!-- 전체출력(시작) -->
		
		<c:forEach var="se" items="${requestScope.all}" begin="${param.start}" end="${param.start+9}">
			<c:set var="perPage" scope="session" value="10"/><!-- 페이징처리 -->
			<c:set var="totalPages" scope="session" value="${se.total/perPage}"/><!-- 페이징처리 -->
			<c:set var="pageIndex" scope="session" value="${param.start/perPage+1}"/><!-- 페이징처리 -->
			<c:set var="totalCount" scope="session" value="${se.total}"/><!-- 페이징처리 -->
			<tr>
				<td><c:out value="${se.post_number}"/></td>
				<td><c:out value="${se.title}" /></td>
				<td><c:out value="${se.id}" /></td>
				<td><a href="click.do?click_post_number=${se.post_number}"><c:out value="${se.post_title}"/></a></td>
				<td><c:out value="${se.registration_date}"/></td>
				<td><c:out value="${se.views}"/></td>
					<c:if test="${vo.id==se.id || vo.rating==3}">
				<td><a href ="delete_hugi.do?del_post_number=${se.post_number}">삭제 </a></td>
           		<td><a href ="find_hugi.do?find_post_number=${se.post_number}">수정 </a></td>
           			</c:if>		
			</tr>
		
		</c:forEach>
		<!-- 전체출력(끝) -->
</table>
		 <!-- 페이징처리(시작) -->
		 <%if(session.getAttribute("searchKeyword")==null){%>
			<c:if test="${!empty param.start && param.start >(perPage-1) && param.start !=0 }">
        	  <a href="/AcodaProject/post_board/select_hugi.do?start=<c:out value="${param.start - perPage}"/>">[이전]</a>
			</c:if>
   			<c:forEach var="boundaryStart" varStatus="status" begin="0" end="${totalCount - 1}" step="${perPage}">
				<c:choose>
				
       		     	<c:when test="${status.count>0 && status.count != pageIndex}">
						<a href="/AcodaProject/post_board/select_hugi.do?start=<c:out value='${boundaryStart}'/>">
							[<c:out value="${status.count}"/>] 
						</a>
					</c:when>
					
				<c:otherwise>
					[<c:out value="${status.count}"/>]
				</c:otherwise>
        		</c:choose>
			</c:forEach>
			<c:if test="${empty param.start || param.start<(totalCount-perPage)}">
				<a href="/AcodaProject/post_board/select_hugi.do?start=<c:out value="${param.start + perPage}"/>">[다음]</a>
			</c:if>
		<%}else{%>
			<c:if test="${!empty param.start && param.start >(perPage-1) && param.start !=0 }">
        	  <a href="/AcodaProject/post_board/search_hugi.do?start=<c:out value="${param.start - perPage}"/>&searchKeyword=<%=searchKeyword%>">[이전]</a>
			</c:if>
   			<c:forEach var="boundaryStart" varStatus="status" begin="0" end="${totalCount - 1}" step="${perPage}">
				<c:choose>
       		     	<c:when test="${status.count>0 && status.count != pageIndex}">
						<a href="/AcodaProject/post_board/search_hugi.do?start=<c:out value='${boundaryStart}'/>&searchKeyword=<%=searchKeyword%>">
							[<c:out value="${status.count}"/>]
						</a>
				</c:when>
				<c:otherwise>
					[<c:out value="${status.count}"/>]
				</c:otherwise>
        		</c:choose>
			</c:forEach>
			<c:if test="${empty param.start || param.start<(totalCount-perPage)}">
				<a href="/AcodaProject/post_board/search_hugi.do?start=<c:out value="${param.start + perPage}"/>&searchKeyword=<%=searchKeyword%>">[다음]</a>
			</c:if>
		<%}%>
		<!-- 페이징처리끝 -->
		<hr>
		
<!-- 검색창 -->
<form action="/AcodaProject/post_board/search_hugi.do?start=0" method="get">
	<input name="searchKeyword" type="text" id="searchKeyword"/>
	<input type="submit" value="검색"/>
</form>
<a href="/AcodaProject/post_board/select_hugi.do?start=0">후기게시판 </a><br>
<a href="/AcodaProject/post_board/insert_hugi_page.do">후기게시판 글작성하기</a><br>
<a href="/AcodaProject/index.jsp">메인페이지로</a><br>

</body>
</html>