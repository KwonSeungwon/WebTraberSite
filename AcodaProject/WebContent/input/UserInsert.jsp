<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body style="font-size:2.0em;margin: 150px 150px 150px 150px;">
	<h3>회원가입</h3> 
	<form action="/AcodaProject/abc.do" method="POST">
	회원번호 : <input type="text" name="usernumber">
	등급코드 : <input type="text" name="rating"><br> 
	아이디 : <input type="text" name="id"><br> 
	패스워드 : <input type="password" name="pw"><br> 	
	핸드폰번호 : <input 	type="text" name="phone"><br>	
	주소 : <input 	type="text" name="address"><br> 
	이메일 : <input type="text" name="email"><br> 	
	가입일 : <input type="date" name="joindate"><br> 
	직업 : <input type="text" name="job"><br> 	
	생년월일 : <input type="date" name="birth"><br> 
	프로필 : <input type="text" name="profile"><br> 
	지역 : <input 	type="text" name="place"><br>  
	<input type="submit" value="등록">
	<input type="reset" value="재작성">
	</form>

</body>
</html>