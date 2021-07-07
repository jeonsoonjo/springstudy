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
		// 페이지 로드
		$(document).ready(function(){
			fn_update();
			fn_delete();
			fn_list();
		});
		// 게시글 수정
		function fn_update(){
			$('#update_btn').click(function(){
				$('#f').attr('action', 'updateImgBoard.do');
				$('#f').submit();
			});
		}
		// 게시글 삭제
		function fn_delete(){
			$('#delete_btn').click(function(){
				if (confirm('삭제할까요?')) {
					location.href = 'deleteImgBoard.do?idx=${imgBoard.idx}';
				}
			});
		}
		// 게시글 목록	
		function fn_list(){
			$('#list_btn').click(function(){
				location.href = 'selectImgBoardList.do';
			});
		}
	</script>
</head>
<body>
	
	<h3>${imgBoard.idx}번 게시글</h3>
	
	<form id="f" method="post" enctype="multipart/form-data">
		<p class="writer">작성자</p>
		<input type="text" id="writer" name="writer" value="${loginUser.id}" readonly><br><br>
		
		제목: ${imgBoard.title}<br>
		작성자: ${imgBoard.writer}<br>
		조회수: ${imgBoard.hit}<br>
		내용: ${imgBoard.content}<br>
		첨부파일:
		<%-- <img alt="${imgBoard.save_filename}" src="resources/archive/${imgBoard.filename}" style="width: 300px;"><br><br> --%>
		작성일: ${imgBoard.postdate}<br><br>
	
	
		<input type="hidden" name="idx" value="${imgBoard.idx}">
		<input type="hidden" name="title" value="${imgBoard.title}">
		<input type="hidden" name="content" value="${imgBoard.content}">
		<input type="hidden" name="filename1" value="${filename}">
		<input type="button" value="수정하기" id="update_btn">
		<input type="button" value="삭제하기" id="delete_btn">
		<input type="button" value="목록보기" id="list_btn">
	</form>
	
</body>
</html>

