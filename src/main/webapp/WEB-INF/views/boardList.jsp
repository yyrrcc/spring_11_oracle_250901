<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h3>게시판 글목록 입니다.</h3>
	<h4>총 게시글 수 : []</h4>
	<hr />
	<table border="1" cellspacing="0" cellpadding="0">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>아이디</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>등록일</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${boardDtos }" var="board">
			<tr>
				<td>${board.bnum }</td>
				<td>${board.btitle }</td>
				<td>${board.bwriter }</td>
				<td>${board.memberDto.membername }</td>
				<td>${board.bhit }</td>
				<td>${board.bdate }</td>
				<td>
					<input type="button" value="삭제" onclick="javascript:window.location.href='boarddelete?bnum=${board.bnum}'">
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<hr />
	<a href="bwrite">글쓰기</a>
	<a href="#">글삭제</a>
</body>
</html>