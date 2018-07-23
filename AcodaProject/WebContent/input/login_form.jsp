<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
<form action="/AcodaProject/login.do" method= "POST">
<input type = "text" name = "id">
<input type = "password" name = "pw">
<input type = "submit" value = "로그인">
<input type = "reset" value =  "취소">
</form>
</body>
</html>
