<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.acoda.vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String searchKeyword = (String)session.getAttribute("searchKeyword"); %>
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
      <!--페이징처리 페이지 계산  -->
         <c:forEach var="pr" items="${requestScope.list}" begin="${param.start}" end="${param.start+9}">            
         <c:set var="perPage" scope="session" value="10"/><!-- 페이징처리(나오는 페이지 수 10개)  -->
         <c:set var="totalPages" scope="session" value="${pr.total/perPage}"/><!-- 페이징처리 -->
         <c:set var="pageIndex" scope="session" value="${param.start/perPage+1}"/><!-- 페이징처리 -->
         <c:set var="totalCount" scope="session" value="${pr.total}"/><!-- 페이징처리 -->
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

               <td><a href="pupinfo.do?item_number=${pr.item_number}">수정 </a></td>
               </c:if>
               
               <c:if test="${vo.id == pr.id }">
               <td><a href="aplication.do?aplic_number=${pr.item_number}">신청서 확인 </a></td>
               </c:if>

            </tr>
         </c:forEach>
      </tbody>
   </table>
   <!--페이징 처리  -->
    <%if(session.getAttribute("searchKeyword")==null){%>
      <c:if test="${!empty param.start && param.start >(perPage-1) && param.start !=0 }">
             <a href="/AcodaProject/product/select.do?start=<c:out value="${param.start - perPage}"/>">[이전]</a>
         </c:if>
            <c:forEach var="boundaryStart" varStatus="status" begin="0" end="${totalCount - 1}" step="${perPage}">
            <c:choose>
            
                     <c:when test="${status.count>0 && status.count != pageIndex}">
                  <a href="/AcodaProject/product/select.do?start=<c:out value='${boundaryStart}'/>">
                     [<c:out value="${status.count}"/>] 
                  </a>
               </c:when>
               
            <c:otherwise>
               [<c:out value="${status.count}"/>]
            </c:otherwise>
              </c:choose>
         </c:forEach>
         <c:if test="${empty param.start || param.start<(totalCount-perPage)}">
            <a href="/AcodaProject/product/select.do?start=<c:out value="${param.start + perPage}"/>">[다음]</a>
         </c:if>
         <%}else{%>
         <c:if test="${!empty param.start && param.start >(perPage-1) && param.start !=0 }">
             <a href="/AcodaProject/product/search.do?start=<c:out value="${param.start - perPage}"/>&searchKeyword=<%=searchKeyword%>">[이전]</a>
         </c:if>
            <c:forEach var="boundaryStart" varStatus="status" begin="0" end="${totalCount - 1}" step="${perPage}">
            <c:choose>
                     <c:when test="${status.count>0 && status.count != pageIndex}">
                  <a href="/AcodaProject/product/search.do?start=<c:out value='${boundaryStart}'/>&searchKeyword=<%=searchKeyword%>">
                     [<c:out value="${status.count}"/>]
                  </a>
            </c:when>
            <c:otherwise>
               [<c:out value="${status.count}"/>]
            </c:otherwise>
              </c:choose>
         </c:forEach>
         <c:if test="${empty param.start || param.start<(totalCount-perPage)}">
            <a href="/AcodaProject/product/search.do?start=<c:out value="${param.start + perPage}"/>&searchKeyword=<%=searchKeyword%>">[다음]</a>
         </c:if>
      <%}%>
         
         <!-- 검색  -->
   <form action="search.do" method="get">
      
          <input name="searchKeyword" type="text" id="searchKeyword" /> <input type="submit" value="검색" /></td>
         
   </form>
   <c:if test="${vo.rating==2}">
      <a href="/AcodaProject/input/input_product.jsp">상품 등록</a>
   </c:if>
   <a href="/AcodaProject/index.jsp">메인페이지로</a>

</body>
</html>