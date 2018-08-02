<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>신청서</h3>
국적(nationallity):<input type="text" name="nationallity"/>
사용언어(language) :<input type ="text" name="language"/><br>
인원수(fellow_traveler):<input type="text" name="fellow_traveler"/><br>
특이사항(unusual):<input type="text" name="unusual"/><br>

<!--  가이드 이메일로 보낼수 있게,신청인의 이름,신청인의 id,주문날짜 controller에서 세션 처리  -->
 	   <input type="submit" value="신청 "/>
       <input type="reset" value="취소 "/>
</body>
</html>