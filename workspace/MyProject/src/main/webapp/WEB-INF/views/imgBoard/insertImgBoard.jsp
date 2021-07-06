<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">

	</script>
</head>
<body>

	<h1>게시글 작성</h1>
	<div class="insertImgBoard_form">
		<form action="insertImgBoard.do" method="post" enctype="multipart/form-data">
			<p class="naming">작성자</p>
			<input type="text" id="writer" name="writer" value="${imgBoard.writer}" readonly><br><br>
			
			<p class="naming">제목</p>
			<input type="text" id="title" name="title" autofocus><br><br>
			
			<p class="naming">첨부파일</p>
			<input type="file" id="filename" name="filename"><br><br>
			
			<p class="naming">내용</p>
			<textarea id="content" name="content"></textarea><br><br>
			<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>">

			<button>저장하기</button>
			<input type="reset" class="btn" value="작성 초기화" id="reset_btn">
			<input type="button" class="btn" value="목록보기" id="list_btn" onclick="location.href='selectImgBoardList.do'">

		</form>
	</div>
	
</body>
</html>

