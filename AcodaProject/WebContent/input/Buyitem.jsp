<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>***상품 구매 페이지***</h2>
	<form action="/AcodaProject/UserOdrer.do" method="POST" id="infrom">
		이름 : <input type="text" name="item_number" class="na"><br>
		이름 : <input type="text" name="user_number" class="na"><br>
		이름 : <input type="text" name="order_number" class="na"><br>
		이름 : <input type="text" name="order_day" class="na"><br>
		이름 : <input type="text" name= "nationality class="na"><br>
		이름 : <input type="text" name="fellow_traveler" class="na"><br>
		이름 : <input type="text" name="language" class="na"><br>
		이름 : <input type="text" name="unusual" class="na"><br>
		<input type = "submit" value = "구매하기">
		<input type = "button" onclick="location.href=''" value = "뒤로가기">
	</form>

</body>
</html>