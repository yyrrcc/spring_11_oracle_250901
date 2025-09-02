<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글</title>
</head>
<body>
	<h3>상세 글 보기</h3>
	<hr />
	
	<form action="boardModify">
	<input type="hidden" name="bnum" value="${boardDto.bnum }"><br />
	글쓴이 <input type="text" name="bwriter" value="${boardDto.memberDto.membername }" readonly><br />
	제목 <input type="text" name="btitle" value="${boardDto.btitle }"><br />
	글내용 <textarea rows="10" cols="45" name="bcontent">${boardDto.bcontent }</textarea><br />
	조회수 : ${boardDto.bhit } <br />
	작성일 : <fmt:formatDate value="${boardDto.bdate }" pattern="yyyy-MM-dd HH:mm"/> <br />
	<input type="submit" value="수정완료">
	</form>
	<a href="blist">글 목록으로 가기</a>
</body>
</html>