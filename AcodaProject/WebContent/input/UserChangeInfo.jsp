<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body style="font-size:2.0em;margin: 150px 150px 150px 150px;">
	<h3>회원정보수정</h3> 
	<form action="/AcodaProject/changeuser.do" method="POST">
	회원유형 :
	<input type = "radio" name = "rating" id = "nomal" value = "1" onclick ="this.form.place.disabled=true ; this.form.profile.disabled=true">일반회원 
	<input type = "radio" name = "rating" id = "guide" value = "2" onclick ="this.form.place.disabled=false ; this.form.profile.disabled=false">가이드회원<br> 
	새 비밀번호 입력 : <input type="password" name="id"><br>
	성별 : <input type="text" name="sex"><br>
	전화번호 입력 : <input type="text" name="phone"><br>
	주소 입력 : <input type="text" name="address"><br>
	직업 입력 : <input type="text" name="job"><br>
	생년월일 입력 : <input type="date" name="birth"><br>
	직업 : <input type="text" name="job" class = "jo"><br> 	
	프로필 : <input type="text" name="profile" class = "pt"><br> 
	지역 : <input type="text" name="place"><br>
	<input type="submit" value="수정완료">
	<input type="button" value="취소" onclick="location.href ='/AcodaProject/index.jsp'">
	</form>

</body>
</html>