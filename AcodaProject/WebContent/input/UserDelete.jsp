<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
$(document).ready(function() {
 	$("#dform").submit(function() {
 		
 		
	});
});

 
</script>
<body style="font-size:2.0em;margin: 150px 150px 150px 150px;">
	<h3>회원탈퇴</h3>
	<h5>아이디와 비밀번호를 다시한번 입력해주세요</h5> 
	<form action="/AcodaProject/deleteuser.do" method="POST"  id = "dform">
	회원아이디입력 : <input type="text" name="id"> 
	비밀번호입력 : <input type="password" name="pw">  	 
	<input type="submit" value="탈퇴하기">
	<input type="button" value="취소" onclick="location.href ='/AcodaProject/index.jsp'">
	</form>

</body>
</html>