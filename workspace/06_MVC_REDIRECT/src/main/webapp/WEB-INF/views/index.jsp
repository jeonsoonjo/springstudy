<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<form action="/mvc04/" method="post"> <!-- mapping값은 /(슬래시)를 사용해도 되고 안 해도 되지만, form action값은 무조건 /를 사용해야 한다(안 그럼 폴더로 인식함) -->
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="age" placeholder="나이"><br><br>
		<button>전송</button>
	</form>

</body>
</html>

