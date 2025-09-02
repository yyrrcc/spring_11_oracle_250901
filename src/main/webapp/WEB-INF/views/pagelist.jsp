<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>자유 게시판</title>
  <!-- ${pageContext.request.contextPath} 현재 웹 애플리케이션의 컨텍스트 경로 가져오는 동적 표현식  -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pagelist.css"> 
</head>
<body>

  <div class="board-container">
    <div class="board-header">자유 게시판</div>
    <table class="board">
      <thead>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach items="${boardDtos }" var="board">
	        <tr>
	          <td>${board.bnum }</td>
	          <td><a href="boardview?bnum=${board.bnum }">${board.btitle }</a></td>
	          <td>${board.bwriter }</td>
	          <td><fmt:formatDate value="${board.bdate }" pattern="yyyy-MM-dd"/></td>
	        </tr>
        </c:forEach>
      </tbody>
    </table>

    <div class="pagination">
      <a href="#">&laquo;</a>
      <a href="#">&lsaquo;</a>
      <a href="#" class="active">1</a>
      <a href="#">2</a>
      <a href="#">3</a>
      <a href="#">4</a>
      <a href="#">5</a>
      <a href="#">&rsaquo;</a>
      <a href="#">&raquo;</a>
    </div>
  </div>

</body>
</html>

