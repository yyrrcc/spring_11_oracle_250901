<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>외부 파일 불러오기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"> 
</head>
<body>
	<h3>이미지 불러오기</h3>
	<img src="resources/img/dog.jpg" width="200px">
	<p>이미지 속성을 눌렀을 때 : http://localhost:8888/oracle/resources/img/dog.jpg 주소가 나온다 <br />
	이건 로컬 주소이기 때문에 다음과 같이 코드를 넣어줘야 한다. $ { pageContext.request.contextPath } <br />
	jsp에서는 /oracle로 보임!</p>
	<hr />
	<img src="${pageContext.request.contextPath}/resources/img/dog.jpg" width="200px">
	 
</body>
</html>