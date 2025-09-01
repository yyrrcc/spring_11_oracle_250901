<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="bwriteOk">
		글쓴이 <input type="text" name="bwriter" value="${sessionScope.sessionId }" readonly><br />
		제목 <input type="text" name="btitle"><br />
		글내용 <textarea rows="10" cols="45" name="bcontent"></textarea><br />
		<input type="submit" value="글쓰기">
		<a href="blist">글목록으로 가기</a>
	</form>
</body>
</html>