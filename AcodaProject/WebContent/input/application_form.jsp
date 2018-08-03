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
	<h3>
		신청서<input type="hidden" name="application" />
	</h3>
	<form action="/AcodaProject/buy/insert.do?a=${b} "method="post">

		상품번호:<input type="text"  name="item_number" value="${b}" /> 
		국적:<input type="text" name="nationallity" />
		사용언어(language) :<input type="text" name="language" /><br>
		인원수(fellow_traveler):<input type="text" name="fellow_traveler" /><br>
		특이사항(unusual):<input type="text" name="unusual" /><br>
		<input type="hidden" name="user_number" value=<%=vo.getUser_number()%>/><!--user_number  -->
		<input type="hidden" name="ordr_day" value = <%=today%> /><!-- 주문날짜 -->
		<!--  상품번호,회원고유번호,가이드 이메일로 보낼수 있게,신청인의 이름,신청인의 id,주문날짜 controller에서 세션 처리  -->
		<input type="submit" value="신청 " /> <input type="reset" value="취소 " />
	</form>
</body>
</html>