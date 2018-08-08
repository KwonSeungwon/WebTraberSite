<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*,com.acoda.vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <%
      MemberVO vo = (MemberVO) session.getAttribute("login");
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String today = sdf.format(new Date());
   %>
<form action="/AcodaProject/festival/update.do" method="post">
수정하세요 <br><br><br>
     	축제글 번호 : <input name="f_number" value="${find.f_number}" required="true" readonly="readonly"/><br>
     	축제 이름 : <input type="text" name="f_name" required="true" /><br>
  	  	계절:<input type="text" name="season" required="truev"/><br>
 		축제 시작날짜 : <input type="date" name="f_start_date" required="true"/><br>
 		축제 마지막 날짜 : <input type="date" name="f_end_date" required="true"/><br><br>
	 	축제 장소 : <input type="text" name="f_local"  required="true"/><br>
    	축제 내용 : <input type="text" name="f_contents"  required="true"/><br>

     
       <input type="submit" value="확인 "/>
       <input type="button" value="취소 " onclick="location.href='/AcodaProject/festival/select.do'"/>
 </form>
<!--  <a href="/AcodaProject/festival/select.do">축제 게시판 보기</a> -->
 <a href="/AcodaProject/index.jsp">메인페이지로</a>
</body>
</html>