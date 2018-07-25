<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, java.text.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>

<body style="font-size:2.0em;margin: 150px 150px 150px 150px;">
	<h3>회원가입</h3> 
	<form action="/AcodaProject/abc.do" method="POST">
	가입유형 : 
	<input type = "radio" name = "rating" value = "1" onclick ="this.form.place.disabled=true ; this.form.profile.disabled=true">일반회원 
	<input type = "radio" name = "rating" value = "2" onclick ="this.form.place.disabled=false ; this.form.profile.disabled=false">가이드회원<br> 
	이름 : <input type="text" name="name"><br>
	성별 : <input type="text" name="sex"><br>
	아이디 : <input type="text" name="id" class = "idtest"/> <input type = "button" id = "idcheck" value ="아이디 중복체크"/>
	<script type="text/javascript">
	$(document).ready(function () {	
		  $("#idcheck").click(function(){
			var value = $(".idtest").val();
			if(value == ""){
				alert('아이디를 입력하세요');
				history.back();
			}else{
				alert(value);
				location.href ='../idcheck.do?id =' + value;
			}
		});
	});
	</script>
	패스워드 : <input type="password" name="pw"><br> 	
	핸드폰번호 : <input type="text" name="phone"><br>	
	주소 : <input 	type="text" name="address"><br> 
	이메일 : <input type="text" name="email" class = "testemail"> <input type = "button" id = "emailcheck" value ="이메일 중복체크" onclick="location.href ='emailcheck.do'"><br>
	<script type="text/javascript">	
	$(document).ready(function () {	
		  $("#emailcheck").click(function(){
			var emailV = $('.testemail').val();
			if(emailV == ""){
				alert('이메일을 입력하세요');
				history.back();
			}else{
			alert(emailV);

			}
		});
	});
	</script> 	
	직업 : <input type="text" name="job"><br> 	
	생년월일 : <input type="date" name="birth"><br> 
	프로필 : <input type="text" name="profile"><br> 
	지역 : <input 	type="text" name="place"><br>  
	<input type="submit" value="등록">
	<input type="reset" value="재작성">
	</form>

</body>
</html>