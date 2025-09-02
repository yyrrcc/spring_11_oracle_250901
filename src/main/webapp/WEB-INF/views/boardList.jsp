<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h3>게시판 글목록 입니다.</h3>
	<h4>총 게시글 수 : ${boardCount }</h4>
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
		<!-- varStatus="status" ${boardCount - status.index} 로도 결번없이 글번호 매길 수 있음 -->
		<c:forEach items="${boardDtos }" var="board">
			<tr>
				<td>${board.bnum }</td>
				<td><a href="boardview?bnum=${board.bnum }">${board.btitle }</a></td>
				<td>${board.bwriter }</td>
				<td>${board.memberDto.membername }</td>
				<td>${board.bhit }</td>
				<td>
					<fmt:formatDate value="${board.bdate }" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					<input type="button" value="삭제"
					onclick="if(confirm('정말 삭제하시겠습니까?')){window.location.href='boarddelete?bnum=${board.bnum}';}">
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<hr />
	<input type="button" value="글쓰기" onclick="javascript:window.location.href='bwrite'">
</body>
</html>