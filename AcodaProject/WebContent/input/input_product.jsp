<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="com.acoda.vo.MemberVO"%>
<%@page import = "java.util.Date"%>
<%@page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 등록</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
$(document).ready(function() {
   $(".pbtn").click(function() {
	   if ($("#picbu").val() != "") {
			var ext = $('#picbu').val().split('.').pop().toLowerCase();
			if ($.inArray(ext, [ 'gif', 'png', 'jpg', 'jpeg' ]) == -1) {
				alert('gif,png,jpg,jpeg 파일만 업로드 할수 있습니다.');
				return false;
			}
		}
      var F_Data = new FormData($("#fileupform")[0]);      
      $.ajax({ 
         url:'/AcodaProject/product/picup.do',
         data: F_Data, 
         processData: false, 
         contentType: false,
         type : 'POST',
         datatype : "text",
         success: function(result){
            alert("업로드 완료");
            $('.location').val(result);
            $("#my_image").attr("src",result);

            }
         });
      });
   });   
</script>
<script type="text/javascript">
$(document).ready(function() {
 	$("#fileupform").submit(function() {
		var pname = $('.pn').val();
		var price = $('.pr').val();
		var hcount = $('.hcount').val();
		var sc = $('.sc').val();
		var td = $('.td').val();
		var note = $('.note').val();
		var location = $('.location').val();
		if(pname=="" || price=="" || hcount=="" || sc=="" || td=="" || note=="" || location==""){
			alert("상품등록 내용은 모두 필수로 작성하셔야 합니다.");
			return false;
		}else{
			alert("등록되었습니다.");
			return true;
		}
 	}); 
});
</script>
</head>
<body>
	<h2>여기는 가이드가 상품을 등록하는 페이지 입니다.</h2>
	<%
		MemberVO vo = (MemberVO) session.getAttribute("login");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
	%>
	<form action="/AcodaProject/product/insert.do" method="post" enctype="multipart/form-data" id = "fileupform">
	<!-- 	 상품번호 <input type="text" name="item_number"/><br>  -->
		상품이름 :<input type="text" name="product_name" class = "pn" /><br> 
		가격  :<input type="text" name="price" class = "pr"/><br> 
		수용인원 :<input type="text"name="head_count" class = "hcount" /><br> 
		상세일정  :<input type="text" name="schedule" class="sc"/>
		<!-- <textarea rows="3" cols="20" name="schedule"></textarea> -->
		<!-- <input type="text" name="schedule" class = "sc"/><br> -->
		일정 :<input type="date" name="trip_date" class = "td" /> <input type="date" name="trip_date"/><br> 
		참고사항  :<input type="text" name="note" class = "note"/><br>
		가이드사진 : <input type = "file" id = "picbu" name = "fileup"> <input type = "button" value = "업로드하기" class = "pbtn"><br>		
		올린사진 : <img id = "my_image" src ="" height="200"/><br>
		<input type="hidden" name ="sell_date" value = <%=today%>><br> 
		<input type = "hidden" name ="pic" class = "location">
		<input type="hidden"name="user_number" value=<%=vo.getUser_number()%>><br>
		
		<input type="submit" value="등록" class = "rbtn" /> 
		<input type="button" value="취소 " onclick="location.href='/AcodaProject/product/select.do'" />
	</form>
<!-- 	<a href="/AcodaProject/product/select.do">상품 목록</a>-->	
<a href="/AcodaProject/index.jsp">홈으로</a>
</body>
</html>