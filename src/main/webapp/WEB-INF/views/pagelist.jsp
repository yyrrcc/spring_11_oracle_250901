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
    <div class="board-header"><a href="pagelist">자유 게시판</a></div>
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
      	<c:forEach items="${boardDtos }" var="board" varStatus="status">
	        <tr>
	          <td>${boardCount - (board.rnum - 1) }</td> <!-- rnum 이용해서 공백 없는 글 번호 가져오기 -->
	          <td><a href="boardview?bnum=${board.bnum }">${board.btitle }</a></td>
	          <td>${board.bwriter }</td>
	          <td><fmt:formatDate value="${board.bdate }" pattern="yyyy-MM-dd"/></td>
	        </tr>
        </c:forEach>
      </tbody>
    </table>

    <div class="pagination">
      <c:if test="${pageNum > 1 }">
      	<a href="pagelist?pageNum=1">&laquo;</a>
      	<a href="pagelist?pageNum=${pageNum - 1 }">&lsaquo;</a>
      </c:if>
	  <c:forEach begin="${startPage}" end="${endPage }" var="i">
	  	  <c:choose>
	  	  	<c:when test="${i == pageNum }">
	  	  		<a href="#" class="active">${i }</a>
	  	  	</c:when>
	  	  	<c:otherwise>
	  	  		<a href="pagelist?pageNum=${i }">${i }</a>
	  	  	</c:otherwise>
	  	  </c:choose>
	  </c:forEach>
      <c:if test="${pageNum < totalPage }">
      	<a href="pagelist?pageNum=${pageNum + 1 }">&rsaquo;</a>
      	<a href="pagelist?pageNum=${totalPage }">&raquo;</a>
      </c:if>
    </div>
  </div>

</body>
</html>

