<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			$('#update_page_btn').click(function(){
				$('#f').attr('action', 'updateBoardPage.do');
				$('#f').submit();
			})
			$('#delete_btn').click(function(){
				if (confirm('삭제할까요?')) {
					location.href = 'deleteBoard.do?no=${board.no}';
				}
			})
			$('#list_btn').click(function(){
				location.href = 'selectBoardList.do';
			})
		})
	</script>
</head>
<body>
	
	<h1>${imgBoard.idx}번 게시글</h1>
	제목: ${imgBoard.title}<br>
	작성자: ${imgBoard.writer}<br>
	조회수: ${imgBoard.hit}<br>
	내용: ${imgBoard.content}<br>
	첨부파일: ${imgBoard.filename}<br>
	작성일: ${imgBoard.postdate}<br><br>
	
	<form id="f" method="post">
		<input type="hidden" name="idx" value="${imgBoard.idx}">
		<input type="hidden" name="title" value="${imgBoard.title}">
		<input type="hidden" name="content" value="${imgBoard.content}">
		<input type="button" value="수정하러가기" id="update_page_btn">
		<input type="button" value="삭제하기" id="delete_btn">
		<input type="button" value="목록으로이동" id="list_btn">
	</form>
	
</body>
</html>

