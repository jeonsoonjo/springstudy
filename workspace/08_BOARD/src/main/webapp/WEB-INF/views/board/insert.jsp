<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>

	<h1>게시글 작성 화면</h1>
	<form action="insertBoard.do">
		작성자<br>
		<input type="text" name="writer"><br><br>
		제목<br>
		<input type="text" name="title"><br><br>
		내용<br>
		<input type="text" name="content"><br><br>
		
		<button>작성하기</button>
	</form>
	
</body>
</html>

