<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.acoda.vo.MemberVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>나들목</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
.navbar {


    margin-bottom: 0px;

}
.carousel {
   position: fixed;
}
 .carousel-control.right,.carousel-control.left
 {
    background-image:none;
    color:#f4511e;
  }
  .carousel-inner img
  {
      width:100%;
      margin:auto;
  }
.carousel-indicators li {
    display:inline-block;
    width:14px;
    height:11px;
    margin:10px;
    text-indent: 0;
    cursor: pointer;
    border:none;
    border-radius: 50%;
    background-color:grey;
    box-shadow:inset 1px 1px 1px 1px rgba(0,0,0,0.5);    
}
.carousel-indicators .active {
    width:14px;
    height:11px;
    margin:10px;
    background-color:#000000;
}
</style>

<body>
<%MemberVO vo = (MemberVO) session.getAttribute("login"); %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/AcodaProject/index.jsp"> 나들목 </a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/AcodaProject/index.jsp"> Home </a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"> 게시판 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/AcodaProject/post_board/select_user.do?start=0"> 유저게시판 </a></li>
          <li><a href="/AcodaProject/post_board/select_hugi.do?start=0"> 후기게시판 </a></li>
        </ul>
      </li>
      <li><a href="/AcodaProject/festival/select.do?start=0"> 축제정보 </a></li>
      <li><a href="/AcodaProject/product/select.do?start=0"> 상품게시판 </a></li>
      <li><a href="/AcodaProject/buy/UserOrderList.do"> 주문상품보기 </a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <%   
      if (session.getAttribute("login") != null) {
   %>
   <li><a href="/AcodaProject/input/UserDelete.jsp"><span class="glyphicon glyphicon-remove"></span> 회원탈퇴 </a></li>
   <li><a href="/AcodaProject/logout.do"><span class="glyphicon glyphicon-log-out"></span> 로그아웃 </a></li>
    <%if(vo.getRating() == 1){ %>
    <li><a href="/AcodaProject/input/UserNomalUpdate.jsp"><span class="glyphicon glyphicon-edit"></span> 회원정보수정 </a></li>
    <%}else if(vo.getRating() == 2){ %>
    <li><a href="/AcodaProject/input/UserGuideUpdate.jsp"><span class="glyphicon glyphicon-edit"></span> 회원정보수정 </a></li>
    <%}else{%>
    <li><a href="Select.do"><span class="glyphicon glyphicon-list"></span> 회원리스트 </a></li>
    <%} %>
    <%
      } else if(session.getAttribute("login") == null) {
   %>
   <li><a href="/AcodaProject/input/login_form.jsp"><span class="glyphicon glyphicon-log-in"></span> 로그인 </a></li>
    <li><a href="/AcodaProject/input/UserInsert.jsp"><span class="glyphicon glyphicon-user"></span> 회원가입 </a></li>
    <%
      }
      %>
    </ul>
  </div>
</nav>

<!-- 이미지 슬라이드 -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="http://img.sbs.co.kr/sbscnbc/upload/2015/04/24/10000486637.jpg"alt="no image" style=height:675px >
        <!-- <div class="carousel-caption"><p>Slide 1</p></div> 캡션사용시 주석제거-->
      </div>
      <div class="item">
        <img src="http://www.hiratv.or.kr/images/vodThumb/%EB%AC%B8%ED%99%94%EB%B6%80_%ED%95%98%EA%B3%84%EA%B5%AD%EB%82%B4%EC%97%AC%ED%96%89%ED%99%9C%EC%84%B1%ED%99%94%EC%BA%A0%ED%8E%98%EC%9D%B8.mp4_20180703_160352.422.jpg"alt="no image" style=height:675px> 
      </div>
      <div class="item">
        <img src="http://i.imgur.com/abasvTt.jpg"alt="no image"style=height:675px>
      </div>
    </div>
<br>
    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>



</body>
</html>