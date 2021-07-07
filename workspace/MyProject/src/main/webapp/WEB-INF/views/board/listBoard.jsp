<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

	<h3>자유 게시판</h3>
	
	<!-- 검색 -->
	<form action="findImgBoard.do">
		<select name="column">
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="WRITER">작성자</option>
		</select>
		<input type="text" name="query">
		<button>검색</button>
		<input type="button" value="전체목록보기" onclick="location.href='selectBoardList.do'">
		<c:if test="${loginUser != null}">
			<input type="button" value="돌아가기" onclick="location.href='myPage.do'">
		</c:if>
		<c:if test="${loginUser == null}">
			<input type="button" value="돌아가기" onclick="location.href='index.do'">
		</c:if>
	</form>
	<br><br>

	<!-- 이미지 게시판 목록 -->
	전체: ${totalRecord}개 게시글
	<!-- 로그인을 해야 작성할 수 있다 -->
	<c:if test="${loginUser != null}">
		<input type="button" value="게시글 작성하기" onclick="location.href='insertBoardPage.do'">
	</c:if>
	<br><br>
	
	<table border="1">
		<thead>
			<tr>
				<td>게시글 번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="5">작성된 게시글이 없습니다.</td>
				</tr>
			</c:if>
			
			<c:if test="${not empty list}">
				<c:forEach var="board" items="${list}" varStatus="k">
					<tr>
						<td>${seq - k.index}</td>
						<td>
							<c:if test="${board.depth == 1}">
								&nbsp;&nbsp;&nbsp;[re]
							</c:if>
							${board.title}
							<c:if test="${board.depth == 0}">
								<font size="1"><a class="link" href="insertReplyPage.do?groupno=${board.groupno}">답글</a></font>
							</c:if>
						</td>
						<td>${board.writer}</td>
						<td>${board.lastmodified}</td>
						<td>${board.hit}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6">
					${paging}
				</td>
			</tr>
		</tfoot>
	</table>
	
</body>
</html>