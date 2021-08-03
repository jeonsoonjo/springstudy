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
		$('document').ready(function(){
			$('#insert_btn').click(function(){
				if($('#writer').val() == '' || $('#title').val() == '' || $('#content').val() == ''){
					alert('입력 내용을 확인하세요.');
					return false;
				} else{
					f.action = 'insertBoard.do';
					f.submit();
				}
			});
		});
			
	</script>
</head>
<body>

	<form id="f" method="post">
		<table border="1">
			<tbody>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="bWriter" id="writer"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="bTitle" id="title"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="50" rows="10" name="bContent" id="content"></textarea></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
				<td colspan="2">
					<input type="button" value="등록" id="insert_btn">
					<input type="button" value="목록" id="list_btn" onclick="location.href='selectBoardList.do';">
				</td>
			</tr>
			</tfoot>
		</table>
	</form>

</body>
</html>
