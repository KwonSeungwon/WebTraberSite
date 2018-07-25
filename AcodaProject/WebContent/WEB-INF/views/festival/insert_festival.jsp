<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>축제글 추가 게시판</title>
</head>
<body>

여기는 관리자가 축제 정보를 올리는 게시판입니다. <br><br><hr>
<form action=" /insert_fe.do" method="post">
축제 글 순서<input type="text" name ="f_number">
이름 <input type="text" name="f_name"><br>
계절<input type="text" name="f_name"><br>
시작일 <input type="text" name="f_name">~
마지막일<input type="text" name="f_name">
장소<input type="text" name="f_name"><br>
내용<input type="text" name="f_name"><br>
회원고유번호<input type="text" name="f_name">

    <input type="submit" value="등록"/>
       <input type="reset" value="취소 "/>

</form>
</body>
</html>