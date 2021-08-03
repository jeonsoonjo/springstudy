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
			$('#insert_btn').click(function(){
				location.href = 'insertBoardPage.do';
			})
		})
	</script>
</head>
<body>

	<h4>총 게시글 : ${totalBoard}개</h4>
	<table border="1">
		<thead>
			<tr>
				<td>순번</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="4">게시물이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="boardDTO" items="${list}">
					<tr>
						<td>${boardDTO.BIdx}</td>
						<td>${boardDTO.BWriter}</td>				
						<td><a href="selectBoardByIdx.do?bIdx=${boardDTO.BIdx}">${boardDTO.BTitle}</a></td>
						<td>${boardDTO.BDate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
					<input type="button" value="새글작성" id="insert_btn">
				</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>
