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
<title>Insert title here</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".idtest").keyup(function() {
			var iddd = $('.idtest').val();
			$.ajax({
				url : "../idcheck.do",
				data : {
					"id" : iddd
				},
				dataType : "text",
				type : "GET",
				success : function(login) {
					var good = "good";
					if (login == "good") {
						$('.idt').val('사용가능한 아이디 입니다.');
						login.focus();
						return true;
					} else {
						$('.idt').val('사용 불가능한 아이디 입니다.');
						result.focus();
						return false;
					}
				}
			});
		});
	});
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$(".testemail")
								.keyup(
										function() {
											var emailV = $('.testemail').val();
											var pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
											if (!pattern.test(emailV)) {
												$('.emailt').val(
														'이메일 형식이 정확하지 않습니다.');
												emailV.focus();
												return false;
											}
											if (pattern.test(emailV)) {
												$('.emailt').val(
														'사용가능한 이메일형식입니다.');
												emailV.focus();
												return true;
											}
										});
					});
</script>
<script type="text/javascript">
$(document).ready(function() {
 	$("#infrom").submit(function() {
		var name = $('.na').val();
		var sex = $('.se').val();
		var id = $('.idtest').val();
		var pw = $('.ppw').val();
		var phone = $('.phh').val();
		var email = $('.testemail').val();
		var job = $('.jo').val();
		var birth = $('.bir').val();
		var rating = $('.ra').val();
		if(name=="" || sex=="" || id=="" || pw=="" || phone=="" || email=="" || job=="" || birth=="" || rating==""){
			alert("미작성된 항목이 있습니다!");
			return false;
		}else{
			alert("회원가입을 축하합니다!");
			return true;
		}
		
 	}); 
});
</script>
<script type="text/javascript">
$(document).ready(function() {
$(function() { $("#abutton").postcodifyPopUp(); 
	}); 
}); 
</script>
<style type="text/css">
body {
    background: #fff;
	font-family: 'Roboto', sans-serif;
	color:#333;
	line-height: 22px;	
}
h1, h2, h3, h4, h5, h6 {
	font-family: 'Roboto Condensed', sans-serif;
	font-weight: 400;
	color:#111;
	margin-top:5px;
	margin-bottom:5px;
}
h1, h2, h3 {
	text-transform:uppercase;
}

input.upload {
    position: absolute;
    top: 0;
    right: 0;
    margin: 0;
    padding: 0;
    font-size: 12px;
    cursor: pointer;
    opacity: 1;
    filter: alpha(opacity=1);    
}

.form-inline .form-group{
    margin-left: 0;
    margin-right: 0;
}
.control-label {
    color:#333333;
}
</style>
</head>

<div class="container">
	<div class="row">
    <div class="col-md-8">
      <section>      
        <h1 class="entry-title"><span>회원가입</span> </h1>
		<hr>
	<form action="/AcodaProject/abc.do" method="POST" id = "infrom" class ="form-horizontal" enctype="multipart/form-data">
	<div class="form-group">
	<label class="control-label col-sm-3">가입유형<span class="text-danger">*</span></label>
	<div class="col-md-8 col-sm-9">
	<label>
	<input type = "radio" name = "rating"  class = "ra" id = "nomal" value = "1" onclick ="this.form.place.disabled=true ; this.form.profile.disabled=true">
	일반회원</label>
	<label>
	<input type = "radio" name = "rating" class = "ra" id = "guide" value = "2" onclick ="this.form.place.disabled=false ; this.form.profile.disabled=false"> 
	가이드회원</label>
	</div><hr>
	</div>
	<div class="form-group">
	<label class="control-label col-sm-3">이름<span class="text-danger">*</span></label>
	<div class="col-md-8 col-sm-9">
	<input type="text" name="name" class = "na" placeholder="이름을 입력해주세요">
	</div>
	</div>
	<div class="form-group">
	<label class="control-label col-sm-3">성별<span class="text-danger">*</span></label>
	<div class="col-md-8 col-sm-9">
	<label>
	<input type="radio" name="sex" class = "se" value = "Male">
	남성</label>
	<label>
	<input type="radio" name="sex" class = "se" value = "FMale">
	여성</label>
	</div>
	</div>
	<div class="form-group">
	<label class="control-label col-sm-3">아이디<span class="text-danger">*</span></label>
	<div class="col-md-8 col-sm-9">
	<input type="text" name="id" class = "idtest" placeholder="아이디를 입력하세요"/><input type="text"  readonly="readonly" class = "idt" style="width:400px; background-color:transparent;border:0 solid black;text-align:left;">
	</div>
	</div>
	<div class="form-group">
	<label class="control-label col-sm-3">비밀번호<span class="text-danger">*</span></label>
	<div class="col-md-8 col-sm-9">
	<input type="password" name="pw" class = "ppw" placeholder="비밀번호를 입력하세요">	
	</div>
	</div>

	핸드폰번호 : <input type="text" name="phone" class = "phh">	
		
	우편번호<input type="text" name="address" readonly="readonly" class="postcodify_postcode5"/>
	<button type="button" id = "abutton">검색</button><br />
	도로명 주소<input type="text" name="address" class="postcodify_address"/><br />
	상세주소 <input type="text" name="address"/><br />
	이메일 : <input type="text" name="email" class = "testemail"> 
	<input type="text"  readonly="readonly" class = "emailt" style="width:400px; background-color:transparent;border:0 solid black;text-align:left;"><br>	
	직업 : <input type="text" name="job" class = "jo"><br> 	
	생년월일 : <input type="date" name="birth" class = "bir"><br>​
	프로필 : <input type="text" name="profile" class = "pt"><br> 
	지역 : <input 	type="text" name="place"><br>
	<input type="submit" value="등록" id = "sub">
	<input type="reset" value="재작성">
	</form>

	</section>
	</div>
	</div>
	</div>
	



</body>
</html>