<%@page import="com.acoda.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.acoda.vo.MemberVO"%>
<%@page import = "java.util.Date"%>
<%@page import = "java.text.SimpleDateFormat" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
$(document).ready(function() {
   $(".pbtn").click(function() {   
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
<title>Insert title here</title>
</head>
<body>
<%
ProductVO vo = (ProductVO) request.getAttribute("ulist");
String date = vo.getTrip_date();
String result[] = date.split("~");
String a = result[0];
String b = result[1];
%>

<h3>상품 수정 페이지</h3>
<form action="/AcodaProject/product/productupdate.do" method="post" enctype="multipart/form-data" id = "fileupform">
		상품이름 :<input type="text" name="product_name" class = "pn" value = "${ulist.product_name}"/><br> 
		가격  :<input type="text" name="price" class = "pr" value ="${ulist.price}"/><br> 
		수용인원 :<input type="text"name="head_count" class = "hcount" value = "${ulist.head_count}"/><br> 
		상세일정  :<input type="text" name="schedule" class = "sc" value = "${ulist.schedule}"/><br>
		일정 :<input type="date" name="trip_date" class = "td" value = <%=a%> /> <input type="date" name="trip_date" value =<%=b%> ><br> 
		참고사항  :<input type="text" name="note" class = "note" value = "${ulist.note}"/><br>
		사진 : <img src = "${ulist.pic}" height="200px" ><br>
		가이드사진 : <input type = "file" id = "picbu" name = "fileup"><br>
	
		경로 : <input type = "text" name ="pic" class = "location" value="${ulist.pic}"> <input type = "button" value = "사진교체" class = "pbtn"><br>
		아이템번호 :<input type= "text" name="item_number" class = "pn" value = "${ulist.item_number}">
		
		<input type="submit" value="수정하기" class = "rbtn" /> 
		<input type="reset" value="전부지우기 " />
</form>
</body>
</html>