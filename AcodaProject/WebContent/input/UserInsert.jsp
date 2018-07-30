<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		var rating = $('#rating').val();
		if(name == "" && sex == "" && id == "" && pw == "" && phone == "" && email == "" && job == "" && birth == "" && val == null){
			alert("미작성된 항목이 있습니다!")
			history.go();
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
</head>
<body style="font-size:2.0em;margin: 150px 150px 150px 150px;">
	<h3>회원가입</h3> 
	<form action="/AcodaProject/abc.do" method="POST" id = "infrom">
	가입유형 : 
	<input type = "radio" name = "rating" id = "nomal" value = "1" onclick ="this.form.place.disabled=true ; this.form.profile.disabled=true">일반회원 
	<input type = "radio" name = "rating" id = "guide" value = "2" onclick ="this.form.place.disabled=false ; this.form.profile.disabled=false">가이드회원<br> 
	이름 : <input type="text" name="name" class = "na"><br>
	성별 : <input type="text" name="sex" class = "se"><br>
	아이디 : <input type="text" name="id" class = "idtest"/> 
	<input type="text"  readonly="readonly" class = "idt" style="width:400px; background-color:transparent;border:0 solid black;text-align:left;"><br>
	패스워드 : <input type="password" name="pw" class = "ppw"><br>		
	핸드폰번호 : <input type="text" name="phone" class = "phh"><br>		
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

</body>
</html>