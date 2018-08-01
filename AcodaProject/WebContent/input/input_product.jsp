<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.acoda.vo.MemberVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 등록</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".pbtn").click(function() {	
		var F_Data = new FormData($("#fileupform")[0]);		
		$.ajax({ 
			url: '/AcodaProject/product/picup.do',
			data: F_Data, 
			processData: false, 
			contentType: false, 
			success: function(html){
				alert("성공");

				}
			});
		});
	});	
</script>
</head>
<body>
	<h2>여기는 가이드가 상품을 등록하는 페이지 입니다.</h2>
	<%
		MemberVO vo = (MemberVO) session.getAttribute("login");
	%>
	<form action="/AcodaProject/product/insert.do" method="post" enctype="multipart/form-data" id = "fileupform">
	<!-- 	 상품번호 <input type="text" name="item_number"/><br>  -->
		상품이름 :<input type="text" name="porduct_name" /><br> 
		가격  :<input type="text" name="price"/><br> 
		수용인원 :<input type="text"name="head_count" /><br> 
		등록일  :<input type="text" name="sell_date" /><br>
		상세일정  :<input type="text" name="schedule" /><br> 
		가이드 하는 날 :<input type="text" name="trip_date" /><br> 
		참고사항  :<input type="text" name="note" /><br>
		가이드사진 : <input type = "file" id = "picbu">
		<input type = "button" value = "업로드하기" class = "pbtn"><br>
		<input type = "text" id = "pic" class = "location">
		<input type="hidden"name="user_number" value=<%=vo.getUser_number()%>><br>
		<input type="submit" value="등록" /> 
		<input type="reset" value="취소 " />
	</form>
	<a href="/AcodaProject/product/select.do">상품 목록</a>
	<a href="/AcodaProject/index.jsp">홈으로</a>
</body>
</html>