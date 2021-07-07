<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		// 페이지 로드
		$(document).ready(function(){
			fn_insert();
		});
		// 게시글 등록
		function fn_insert(){
			$('#insert_btn').click(function(){
				if($('#title').val() == '' || $('#content').val() == ''){
					alert('입력된 값이 없습니다. 작성내용을 확인해주세요.');
					return false;
				}
				$('#f').attr('action', 'insertImgBoard.do');
				$('#f').submit();
			});
		}
	</script>
</head>
<body>

	<h3>게시글 작성</h3>
	
	<form id="f" method="post" enctype="multipart/form-data">
		작성자<br>
		<input type="text" id="writer" name="writer" value="${loginUser.id}" readonly><br><br>
		
		제목<br>
		<input type="text" id="title" name="title" placeholder="제목은 필수입니다" autofocus><br><br>
		
		첨부파일<br>
		<input type="file" id="filename" name="filename"><br><br>
		
		내용<br>
		<textarea id="content" name="content" rows="5" cols="20" placeholder="새 내용입니다."></textarea><br><br>
		<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>">

		<input type="button" class="btn" value="작성하기" id="insert_btn">
		<input type="reset" class="btn" value="작성 초기화" id="reset_btn">
		<input type="button" class="btn" value="목록보기" id="list_btn" onclick="location.href='selectImgBoardList.do'">

	</form>
	
</body>
</html>

