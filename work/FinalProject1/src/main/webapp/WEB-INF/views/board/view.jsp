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
		function fn_update(f) {
			f.action = 'updateBoard.do';
			f.submit();
		}
		function fn_delete(f) {
			if (confirm('정말 삭제하시겠습니까 ?')) {
				f.action = 'deleteBoard.do';
				f.submit();
			}
		}
	</script>
</head>
<body>

	<form id="f">
		<table border="1">
			<tr>
				<td>순번</td>
				<td>${boardDTO.BIdx}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${boardDTO.BWriter}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" id="title" value="${boardDTO.BTitle}">
			</td>
			<tr>
				<td>내용</td>
				<td><textarea cols="50" rows="10" name="bContent" id="content">${boardDTO.BContent}</textarea></td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="hidden" name="bIdx" value="${boardDTO.BIdx}">
					<input type="button" value="수정" id="update_btn" onclick="fn_update(this.form)">
					<input type="button" value="목록" onclick="location.href='selectBoardList.do';">
					<input type="button" value="삭제" id="delete_btn" onclick="fn_delete(this.form)">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
