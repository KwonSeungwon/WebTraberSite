<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%@ page session="true" %>
<body>
<body style="font-size : 2em;margin :150px 150px 150px 150px" >
<h3>로그인성공</h3>
<h1><%= session.getAttribute("userInfo") %></h1>
<h3><%= session.getId() %></h3>
<h3><%= session.getValue("id") %></h3>
<h3><%= session.getClass() %></h3>
<a href = "/TeamProject/outuser.jsp">홈 화면으로 이동</a>


</body>
</html>