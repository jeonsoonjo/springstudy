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

	<h1>이미지 게시판</h1>
	
	<!-- 검색 -->
	<form action="findImgBoard.do">
		<select name="column">
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="WRITER">작성자</option>
		</select>
		<input type="text" name="query">
		<button>검색</button>
		<input type="button" value="전체목록보기" onclick="location.href='selectImgBoardList.do'">
		<input type="button" value="돌아가기" onclick="location.href='index.do'">
	</form>
	<br><br>

	<!-- 이미지 게시판 목록 -->
	전체: ${totalRecord}개 게시글
	<!-- 로그인을 해야 작성할 수 있다 -->
	<c:if test="${loginUser != null}">
		<input type="button" value="게시글 작성하기" onclick="location.href='insertImgBoardPage.do'">
	</c:if>
	<br><br>
	
	<table border="1">
		<thead>
			<tr>
				<td>게시글 번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
				<td>첨부파일</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty imgList}">
				<tr>
					<td colspan="6">작성된 게시글이 없습니다.</td>
				</tr>
			</c:if>
			
			<c:if test="${not empty imgList}">
				<c:forEach var="imgBoard" items="${imgList}">
					<tr>
						<td>${imgBoard.idx}</td>
						<td><a href="selectImgBoardByIdx.do?idx=${imgBoard.idx}">${imgBoard.title}</a></td>
						<td>${imgBoard.writer}</td>	
						<td>${imgBoard.hit}</td>	
						<td>
							<c:if test="${not empty imgBoard.filename}">
								<a href="download.do?filename=${imgBoard.filename}"><i class="fas fa-paperclip"></i></a>
							</c:if>
						</td>		
						<td>${imgBoard.postdate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
</body>
</html>