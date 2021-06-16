<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		$(document).ready(function(){
			
		})
	</script>
</head>
<body>

	<h1>${board.no}번 게시글 수정 페이지</h1>
	<form action="updateBoard.do" method="post">
		제목<br>
		<input type="text" name="title" value="${board.title}"><br><br>
		내용<br>
		<input type="text" name="content" value="${board.content}"><br><br>
		<input type="hidden" name="no" value="${board.no}">
		<button>수정하기</button>
	</form>
	
</body>
</html>

