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
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>유저게시판</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
.navbar {


    margin-bottom: 0px;
    
}
table {
    table-layout: fixed;
    word-wrap: break-word;
}
p {
<<<<<<< HEAD
	position: static;
=======
   position: static;
>>>>>>> branch 'master' of https://github.com/KwonSeungwon/Encore_1jo.git
}
</style>
<body>
<c:set var="vo"  value="${sessionScope.login}"/>
<!-- 메뉴바 -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/AcodaProject/index.jsp"> 나들목 </a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/AcodaProject/index.jsp"> Home </a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"> 게시판 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/AcodaProject/post_board/select_user.do?start=0"> 유저게시판 </a></li>
          <li><a href="/AcodaProject/post_board/select_hugi.do?start=0"> 후기게시판 </a></li>
        </ul>
      </li>
      <li><a href="/AcodaProject/festival/select.do?start=0"> 축제정보 </a></li>
      <li><a href="/AcodaProject/product/select.do?start=0"> 상품게시판 </a></li>
      <li><a href="/AcodaProject/buy/UserOrderList.do"> 주문상품보기 </a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <%   
      if (session.getAttribute("login") != null) {
   %>
   <li><a href="/AcodaProject/input/UserDelete.jsp"><span class="glyphicon glyphicon-remove"></span> 회원탈퇴 </a></li>
   <li><a href="/AcodaProject/logout.do"><span class="glyphicon glyphicon-log-out"></span> 로그아웃 </a></li>
    <%if(vo.getRating() == 1){ %>
    <li><a href="/AcodaProject/input/UserNomalUpdate.jsp"><span class="glyphicon glyphicon-edit"></span> 회원정보수정 </a></li>
    <%}else if(vo.getRating() == 2){ %>
    <li><a href="/AcodaProject/input/UserGuideUpdate.jsp"><span class="glyphicon glyphicon-edit"></span> 회원정보수정 </a></li>
    <%}else{%>
    <li><a href="/AcodaProject/Select.do"><span class="glyphicon glyphicon-list"></span> 회원리스트 </a></li>
    <%} %>
    <%
      } else if(session.getAttribute("login") == null) {
   %>
   <li><a href="/AcodaProject/input/login_form.jsp"><span class="glyphicon glyphicon-log-in"></span> 로그인 </a></li>
    <li><a href="/AcodaProject/input/UserInsert.jsp"><span class="glyphicon glyphicon-user"></span> 회원가입 </a></li>
    <%
      }
      %>
    </ul>
  </div>
</nav>
<!-- 메뉴바끝 -->
<table class="table table-hover">
<<<<<<< HEAD
		<tr>
			<th style="width:10%">게시글번호</th>
			<th style="width:10%">게시판이름</th>
			<th style="width:10%">작성자</th>
			<th style="width:40%">게시글제목</th>
			<th style="width:20%">작성일</th>
			<th style="width:10%">조회수</th>
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
			</tr>
		
		</c:forEach>
		<!-- 전체출력(끝) -->
=======
      <tr>
         <th style="width:10%">게시글번호</th>
         <th style="width:10%">게시판이름</th>
         <th style="width:10%">작성자</th>
         <th style="width:40%">게시글제목</th>
         <th style="width:20%">작성일</th>
         <th style="width:10%">조회수</th>
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
         </tr>
      
      </c:forEach>
      <!-- 전체출력(끝) -->
>>>>>>> branch 'master' of https://github.com/KwonSeungwon/Encore_1jo.git
</table>
<<<<<<< HEAD
	
	<table>
		<tr>
			<th style="width:20%" align="center">
		<a class="btn btn-primary" href="/AcodaProject/post_board/insert_user_page.do" role="button">글쓰기</a>
			</th>
		
		 
		<!-- 페이징처리 검색(시작) -->
		<th style="width:60%" align="center">
		<ul class="pagination">
		 <%if(session.getAttribute("searchKeyword")==null){%>
			<c:if test="${!empty param.start && param.start >(perPage-1) && param.start !=0 }">
        	  <li><a href="/AcodaProject/post_board/select_user.do?start=<c:out value="${param.start - perPage}"/>">이전</a></li>
			</c:if>
   			<c:forEach var="boundaryStart" varStatus="status" begin="0" end="${totalCount - 1}" step="${perPage}">
				<c:choose>
       		     	<c:when test="${status.count>0 && status.count != pageIndex}">
						<li>
							<a href="/AcodaProject/post_board/select_user.do?start=<c:out value='${boundaryStart}'/>">
								<c:out value="${status.count}"/>
							</a>
						</li>
					</c:when>
				<c:otherwise>
					<li class="active"><a><c:out value="${status.count}"/></a></li>
				</c:otherwise>
        		</c:choose>
			</c:forEach>
			<c:if test="${empty param.start || param.start<(totalCount-perPage)}">
				<li><a href="/AcodaProject/post_board/select_user.do?start=<c:out value="${param.start + perPage}"/>">다음</a></li>
			</c:if>
		<%}else{%>
			<c:if test="${!empty param.start && param.start >(perPage-1) && param.start !=0 }">
        	  <li><a href="/AcodaProject/post_board/search_user.do?start=<c:out value="${param.start - perPage}"/>&searchKeyword=<%=searchKeyword%>">이전</a></li>
			</c:if>
   			<c:forEach var="boundaryStart" varStatus="status" begin="0" end="${totalCount - 1}" step="${perPage}">
				<c:choose>
       		     	<c:when test="${status.count>0 && status.count != pageIndex}">
						<li><a href="/AcodaProject/post_board/search_user.do?start=<c:out value='${boundaryStart}'/>&searchKeyword=<%=searchKeyword%>">
							<c:out value="${status.count}"/>
						</a></li>
				</c:when>
				<c:otherwise>
					<li class="active"><a><c:out value="${status.count}"/></a></li>
				</c:otherwise>
        		</c:choose>
			</c:forEach>
			<c:if test="${empty param.start || param.start<(totalCount-perPage)}">
				<li><a href="/AcodaProject/post_board/search_user.do?start=<c:out value="${param.start + perPage}"/>&searchKeyword=<%=searchKeyword%>">다음</a></li>
			</c:if>
		<%}%>
		
		</ul>
		
		<!-- 페이징처리끝 -->
		<th>
		<th style="width:20%" align="right">
			<!-- 검색창 -->
			 
				<form action="/AcodaProject/post_board/search_user.do?start=0" method="get">
					<input name="searchKeyword" type="text" id="searchKeyword"/>
					<input type="submit" value="검색"/>
				</form>
			
			<!-- 검색창끝 -->
			</th>
			</tr>
		</table>
=======
   
   <table>
      <tr>
         <th style="width:20%" align="center">
      <a class="btn btn-primary" href="/AcodaProject/post_board/insert_user_page.do" role="button">글쓰기</a>
         </th>
      
       
      <!-- 페이징처리 검색(시작) -->
      <th style="width:60%" align="center">
      <ul class="pagination">
       <%if(session.getAttribute("searchKeyword")==null){%>
         <c:if test="${!empty param.start && param.start >(perPage-1) && param.start !=0 }">
             <li><a href="/AcodaProject/post_board/select_user.do?start=<c:out value="${param.start - perPage}"/>">이전</a></li>
         </c:if>
            <c:forEach var="boundaryStart" varStatus="status" begin="0" end="${totalCount - 1}" step="${perPage}">
            <c:choose>
                     <c:when test="${status.count>0 && status.count != pageIndex}">
                  <li>
                     <a href="/AcodaProject/post_board/select_user.do?start=<c:out value='${boundaryStart}'/>">
                        <c:out value="${status.count}"/>
                     </a>
                  </li>
               </c:when>
            <c:otherwise>
               <li class="active"><a><c:out value="${status.count}"/></a></li>
            </c:otherwise>
              </c:choose>
         </c:forEach>
         <c:if test="${empty param.start || param.start<(totalCount-perPage)}">
            <li><a href="/AcodaProject/post_board/select_user.do?start=<c:out value="${param.start + perPage}"/>">다음</a></li>
         </c:if>
      <%}else{%>
         <c:if test="${!empty param.start && param.start >(perPage-1) && param.start !=0 }">
             <li><a href="/AcodaProject/post_board/search_user.do?start=<c:out value="${param.start - perPage}"/>&searchKeyword=<%=searchKeyword%>">이전</a></li>
         </c:if>
            <c:forEach var="boundaryStart" varStatus="status" begin="0" end="${totalCount - 1}" step="${perPage}">
            <c:choose>
                     <c:when test="${status.count>0 && status.count != pageIndex}">
                  <li><a href="/AcodaProject/post_board/search_user.do?start=<c:out value='${boundaryStart}'/>&searchKeyword=<%=searchKeyword%>">
                     <c:out value="${status.count}"/>
                  </a></li>
            </c:when>
            <c:otherwise>
               <li class="active"><a><c:out value="${status.count}"/></a></li>
            </c:otherwise>
              </c:choose>
         </c:forEach>
         <c:if test="${empty param.start || param.start<(totalCount-perPage)}">
            <li><a href="/AcodaProject/post_board/search_user.do?start=<c:out value="${param.start + perPage}"/>&searchKeyword=<%=searchKeyword%>">다음</a></li>
         </c:if>
      <%}%>
      
      </ul>
      
      <!-- 페이징처리끝 -->
      <th>
      <th style="width:20%" align="right">
         <!-- 검색창 -->
          
            <form action="/AcodaProject/post_board/search_user.do?start=0" method="get">
               <input name="searchKeyword" type="text" id="searchKeyword"/>
               <input type="submit" value="검색"/>
            </form>
         
         <!-- 검색창끝 -->
         </th>
         </tr>
      </table>
>>>>>>> branch 'master' of https://github.com/KwonSeungwon/Encore_1jo.git
</body>
</html>