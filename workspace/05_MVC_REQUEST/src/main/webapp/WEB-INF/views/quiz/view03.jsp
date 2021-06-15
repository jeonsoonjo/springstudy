<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	
	<h1>view03.jsp</h1>
	<!-- index.jsp에서 보낸 파라미터 -->
	제목 : ${board.title}<br>
	조회수 : ${board.hit}<br>
	작성일 : <fmt:formatDate value="${board.date}" pattern="yyyy-MM-dd" /><br>
	
</body>
</html>


