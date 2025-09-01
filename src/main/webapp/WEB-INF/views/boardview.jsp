<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글</title>
</head>
<body>
	<h3>상세 글 보기</h3>
	<hr /> 
	글 제목 : ${boardDto.btitle } <br />
	아이디 : ${boardDto.bwriter } <br />
	글쓴이 : [멤버 이름을 가져와야 함]<br />
	조회수 : ${boardDto.bhit } <br />
	작성일 : ${boardDto.bdate } <br />
	글 내용 : ${boardDto.bcontent } <br />
	<hr />
	<a href="#">글수정</a>
	<a href="blist">글 목록으로 가기</a>
</body>
</html>