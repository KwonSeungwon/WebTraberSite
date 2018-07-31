<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="com.acoda.vo.MemberVO"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
		<% 
		MemberVO vo = (MemberVO) session.getAttribute("login");
		%>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
$(function() { $("#abutton").postcodifyPopUp(); 
	}); 
}); 
</script>

<body style="font-size:2.0em;margin: 150px 150px 150px 150px;">
	<h3>가이드회원정보수정</h3>  
	<form action="/AcodaProject/changeNomaluser.do" method="POST">
	아이디 : <input type="text" name="id" readonly="readonly" value = <%=vo.getId()%> ><br>
	성별 : <input type="text" name="sex" value = <%=vo.getSex()%> ><br>
	새 비밀번호 입력 : <input type="password" name="pw" value = <%= vo.getPw() %>><br>
	전화번호 입력 : <input type="text" name="phone" value = <%= vo.getPhone() %>><br>
	우편번호<input type="text" name="address" readonly="readonly" class="postcodify_postcode5"/>
	<button type="button" id = "abutton">검색</button><br />
	도로명 주소<input type="text" name="address" class="postcodify_address"/><br />
	상세주소 <input type="text" name="address"/><br />	
	직업 입력 : <input type="text" name="job" value = <%= vo.getJob() %>><br>
	생년월일 입력 : <input type="date" name="birth" value = <%= vo.getBirth() %>><br>
	<input type="submit" value="수정완료">
	<input type="button" value="취소" onclick="location.href ='/AcodaProject/index.jsp'">
	</form>

</body>
</html>