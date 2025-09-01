<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h3>회원가입을 하세요</h3>
	<hr />
	<form action="joinOk" method="post">
		아이디 : <input type="text" name="memberid"><br />
		비밀번호 : <input type="password" name="memberpw"><br />
		이름 : <input type="text" name="membername"><br />
		<input type="submit" value="회원가입">
	</form>
	<c:if test="${not empty error }">
		<h3 style="color:red;">가입란을 다시 작성하시기 바랍니다.</h3>
	</c:if>
</body>
</html>