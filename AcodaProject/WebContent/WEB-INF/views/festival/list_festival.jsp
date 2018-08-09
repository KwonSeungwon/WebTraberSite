<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,com.acoda.vo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String searchKeyword = (String)session.getAttribute("searchKeyword"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>축제 게시판</h2>
<c:set var="vo"  value="${sessionScope.login}" />
<h3><c:out value=" ${vo.rating}"/></h3>
<h1>검색어 :<%=searchKeyword%></h1>
<table border="1">
   <thead style="text-align:center;">
      <tr>
         <th>축제글 번호</th><th>축제이름</th><th>계절</th><th>축제 시작일</th><th>축제 마지막일</th><th>장소</th>
      </tr>
   </thead>
   <tbody style="text-align:left;">
   <c:forEach var="fe" items="${requestScope.all}" begin="${param.start}" end="${param.start+9}">
         <c:set var="perPage" scope="session" value="10"/><!-- 페이징처리 -->
         <c:set var="totalPages" scope="session" value="${fe.total/perPage}"/><!-- 페이징처리 -->
         <c:set var="pageIndex" scope="session" value="${param.start/perPage+1}"/><!-- 페이징처리 -->
         <c:set var="totalCount" scope="session" value="${fe.total}"/><!-- 페이징처리 -->
         <tr>
            <td><c:out value=" ${fe.f_number}"/></td>
            <td><a href="click.do?click_number=${fe.f_number}"><c:out value=" ${fe.f_name}"/></a></td>
            <td><c:out value=" ${fe.season}"/></td>
            <td><c:out value=" ${fe.f_start_date}"/></td>
            <td><c:out value=" ${fe.f_end_date }"/></td>
            <td><c:out value=" ${fe.f_local}"/></td>
            <c:if test="${vo.rating==3}">
            <td> <a  href ="delete.do?del_number=${fe.f_number}">삭제  </a></td>
                <td> <a  href ="find.do?find_number=${fe.f_number}">수정 </a></td>
         </c:if>
         </tr>
         
         </c:forEach>
         </tbody>
</table>
         <%if(session.getAttribute("searchKeyword")==null){%>
         <c:if test="${!empty param.start && param.start >(perPage-1) && param.start !=0 }">
             <a href="/AcodaProject/festival/select.do?start=<c:out value="${param.start - perPage}"/>">[이전]</a>
         </c:if>
            <c:forEach var="boundaryStart" varStatus="status" begin="0" end="${totalCount - 1}" step="${perPage}">
            <c:choose>
                     <c:when test="${status.count>0 && status.count != pageIndex}">
                  <a href="/AcodaProject/festival/select.do?start=<c:out value='${boundaryStart}'/>">
                     [<c:out value="${status.count}"/>]
                  </a>
            </c:when>
            <c:otherwise>
               [<c:out value="${status.count}"/>]
            </c:otherwise>
              </c:choose>
         </c:forEach>
         <c:if test="${empty param.start || param.start<(totalCount-perPage)}">
            <a href="/AcodaProject/festival/select.do?start=<c:out value="${param.start + perPage}"/>">[다음]</a>
         </c:if>
         <%}else{%>
         <c:if test="${!empty param.start && param.start >(perPage-1) && param.start !=0 }">
             <a href="/AcodaProject/festival/search.do?start=<c:out value="${param.start - perPage}"/>&searchKeyword=<%=searchKeyword%>">[이전]</a>
         </c:if>
            <c:forEach var="boundaryStart" varStatus="status" begin="0" end="${totalCount - 1}" step="${perPage}">
            <c:choose>
                     <c:when test="${status.count>0 && status.count != pageIndex}">
                  <a href="/AcodaProject/festival/search.do?start=<c:out value='${boundaryStart}'/>&searchKeyword=<%=searchKeyword%>">
                     [<c:out value="${status.count}"/>]
                  </a>
            </c:when>
            <c:otherwise>
               [<c:out value="${status.count}"/>]
            </c:otherwise>
              </c:choose>
         </c:forEach>
         <c:if test="${empty param.start || param.start<(totalCount-perPage)}">
            <a href="/AcodaProject/festival/search.do?start=<c:out value="${param.start + perPage}"/>&searchKeyword=<%=searchKeyword%>">[다음]</a>
         </c:if>
         <%}%>
         
   <form action="/AcodaProject/festival/search.do?start=0" method="get">

      <input name="searchKeyword" type="text" id="searchKeyword"/>
      <input type="submit" value="검색"/>

   </form>

<c:if test="${vo.rating==3}">
<a href="/AcodaProject/festival/insert_page.do">축제 글작성</a>
</c:if>
<a href="/AcodaProject/index.jsp">메인페이지로</a>
         
         

</body>
</html>