<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.acoda.vo.*" %>
<% 
 
              /* List<Post_BoardVO> all = (List<Post_BoardVO>)request.getAttribute("click");
              MemberVO vo = (MemberVO) session.getAttribute("login"); */
              /* List<ReplyVO> replyall = (List<ReplyVO>)request.getAttribute("replyall"); */
              
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>게시글 클릭</title>
</head>
<body>
<%= session.getAttribute("login") %>
<%
 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 String today = formatter.format(new java.util.Date());
%>
<c:set var="vo"  value="${sessionScope.login}" />
<table border="1" align="center" width="500px" height="auto">
   <c:forEach var="se" items="${requestScope.click}">
      <tr>
         <th>글번호</th><th><c:out value="${se.post_number}"/></th>
      </tr>
      <tr>
         <th>아이디</th><th><c:out value="${se.id}"/></th>
      </tr>
      <tr>
         <th>제목</th><th><c:out value="${se.post_title}"/></th>
      </tr>
      <tr>
         <th>내용</th><th><c:out value="${se.post_contents}"/></th>
      </tr>
      <tr>
         <th>등록일</th><th><c:out value="${se.registration_date}"/></th>
      </tr>
      
      <tr>
         <th>조회수</th><th><c:out value="${se.views}"/></th>
      </tr>
      <tr>
         <th>사진경로</th><th><img src = "${se.path}"/></th>
      </tr>
   </c:forEach>
      <tr>
         <th colspan="2">댓글</th>
      <tr>
   
   <c:forEach var="re" items="${requestScope.replyall}">
   
         <tr>
            <th>아이디</th><th><c:out value="${re.id}"/></th>
         </tr>
         <tr>
            <th>작성일</th><th><c:out value="${re.r_date}"/></th>
         </tr>
         <tr>
            <th>댓글내용</th><th><c:out value="${re.r_comment}"/></th>
         </tr>
         <tr>
            <th><a href="/AcodaProject/reply/delete.do?del_r_number=${re.r_number}&&find_post_number=${re.post_number}">삭제</a></th>
            <th>
               <form action="/AcodaProject/reply/update.do" method="post">
                  <input type="text" name="r_comment" value="${re.r_comment}">
                  <input type="hidden" name="r_number" value="${re.r_number}">
                  <input type="hidden" name="post_number" value="${re.post_number}"/>
                  <input type="submit" value="수정">
               </form>
            </th>
         </tr>
   </c:forEach>
   
</table>   
   ****댓글입력****
   <hr>
   <form action="/AcodaProject/reply/insert.do" method="POST">
      <c:forEach var="se" items="${requestScope.click}">
      <!-- 게시글번호(나중에 히든처리) :  --><input type="hidden" name="post_number" value="${se.post_number}"/>
      <!-- 회원고유번호(나중에 히든처리) :  --><input type="hidden" name="user_number" value="${vo.user_number}"/>
      댓글내용입력 : <input type="text" name="r_comment"/><br>
      <!-- 등록일(나중에 히든처리) :  --><input type="hidden" name="r_date" value="<%=today.toString()%>"/><br>
      </c:forEach>
      <input type="submit" value="입력"/>
   </form>
   <hr>
	<c:forEach var="se" items="${requestScope.click}">
		<tr>
			<th>글번호</th><th><c:out value="${se.post_number}"/></th>
		</tr>
		<tr>
			<th>아이디</th><th><c:out value="${se.id}"/></th>
		</tr>
		<tr>
			<th>제목</th><th><c:out value="${se.post_title}"/></th>
		</tr>
		<tr>
			<th>내용</th><th><c:out value="${se.post_contents}"/></th>
		</tr>
		<tr>
			<th>등록일</th><th><c:out value="${se.registration_date}"/></th>
		</tr>
		<tr>
			<th>조회수</th><th><c:out value="${se.views}"/></th>
		</tr>
		<tr>
			<th>사진경로</th><th><c:out value="${se.path}"/></th>
		</tr>
		<c:if test="${vo.id==se.id || vo.rating==3}">
		<tr>
			<th colspan="2">		
				<a href ="/AcodaProject/post_board/delete_user.do?del_post_number=${se.post_number}">삭제하기</a><br>
   				<a href ="/AcodaProject/post_board/find_user.do?find_post_number=${se.post_number}">수정하기</a>
   			</th>
		</tr>
		</c:if>
	</c:forEach>
		<tr>
			<th colspan="2">댓글</th>
		<tr>
	
	<c:forEach var="re" items="${requestScope.replyall}">
	
			<tr>
				<th>아이디</th><th><c:out value="${re.id}"/></th>
			</tr>
			<tr>
				<th>작성일</th><th><c:out value="${re.r_date}"/></th>
			</tr>
			<tr>
				<th>댓글내용</th><th><c:out value="${re.r_comment}"/></th>
			</tr>
			<tr>
				<th><a href="/AcodaProject/reply/delete.do?del_r_number=${re.r_number}&&find_post_number=${re.post_number}">삭제</a></th>
				<th>
					<form action="/AcodaProject/reply/update.do" method="post">
						<input type="text" name="r_comment" value="${re.r_comment}">
						<input type="hidden" name="r_number" value="${re.r_number}">
						<input type="hidden" name="post_number" value="${re.post_number}"/>
						<input type="submit" value="수정">
					</form>
				</th>
			</tr>
	</c:forEach>
	
</table>	
	<form action="/AcodaProject/reply/insert.do" method="POST">
		<c:forEach var="se" items="${requestScope.click}">
		<!-- 게시글번호(나중에 히든처리) :  --><input type="hidden" name="post_number" value="${se.post_number}"/>
		<!-- 회원고유번호(나중에 히든처리) :  --><input type="hidden" name="user_number" value="${vo.user_number}"/>
		댓글내용입력 : <input type="text" name="r_comment"/><br>
		<!-- 등록일(나중에 히든처리) :  --><input type="hidden" name="r_date" value="<%=today.toString()%>"/><br>
		</c:forEach>
		<input type="submit" value="입력"/>
	</form>
	

</body>
</html>