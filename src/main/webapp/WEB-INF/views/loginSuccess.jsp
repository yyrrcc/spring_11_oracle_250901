<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<h3>${sessionScope.sessionId }님, 로그인에 성공하셨습니다.</h3>
	<a href="logout">로그아웃</a>
	</body>
</html>