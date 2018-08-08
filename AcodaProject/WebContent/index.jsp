<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.acoda.vo.MemberVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>main</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%MemberVO vo = (MemberVO) session.getAttribute("login"); %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp"> 나들목 </a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="index.jsp"> Home </a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"> 게시판 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/AcodaProject/post_board/select_user.do?start=0"> 유저게시판 </a></li>
          <li><a href="/AcodaProject/post_board/select_hugi.do"> 후기게시판 </a></li>
        </ul>
      </li>
      <li><a href="/AcodaProject/festival/select.do"> 축제정보 </a></li>
      <li><a href="/AcodaProject/product/select.do"> 상품게시판 </a></li>
      <li><a href="/AcodaProject/buy/UserOrderList.do"> 주문상품보기 </a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <%   
      if (session.getAttribute("login") != null) {
   %>
   <li><a href="input/UserDelete.jsp"><span class="glyphicon glyphicon-remove"></span> 회원탈퇴 </a></li>
   <li><a href="/AcodaProject/logout.do"><span class="glyphicon glyphicon-log-out"></span> 로그아웃 </a></li>
    <%if(vo.getRating() == 1){ %>
    <li><a href="input/UserNomalUpdate.jsp"><span class="glyphicon glyphicon-edit"></span> 회원정보수정 </a></li>
    <%}else if(vo.getRating() == 2){ %>
    <li><a href="input/UserGuideUpdate.jsp"><span class="glyphicon glyphicon-edit"></span> 회원정보수정 </a></li>
    <%}else{%>
    <li><a href="Select.do"><span class="glyphicon glyphicon-list"></span> 회원리스트 </a></li>
    <%} %>
    <%
      } else if(session.getAttribute("login") == null) {
   %>
   <li><a href="input/login_form.jsp"><span class="glyphicon glyphicon-log-in"></span> 로그인 </a></li>
    <li><a href="input/UserInsert.jsp"><span class="glyphicon glyphicon-user"></span> 회원가입 </a></li>
    <%
      }
      %>
    </ul>
  </div>
</nav>



<!-- Bootstrap core JavaScript
    ================================================== -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>