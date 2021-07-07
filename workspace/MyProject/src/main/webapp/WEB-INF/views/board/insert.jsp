<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<h3>게시글 작성</h3>
	
	<form action="insertBoard.do">
		작성자<br>
		<input type="text" name="writer" value="${loginUser.id}" readonly><br><br>
		제목<br>
		<input type="text" name="title"><br><br>
		내용<br>
		<input type="text" name="content"><br><br>
		<button>작성하기</button>
		<input type="button" value="목록보기" onclick="location.href='selectBoardList.do'">
	</form>
	
</body>
</html>







