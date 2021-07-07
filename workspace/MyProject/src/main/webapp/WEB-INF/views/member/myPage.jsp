<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		// 페이지 로드
		$(document).ready(function(){
			fn_update();
			fn_presentPwCheck();
			fn_updatePw();
			fn_delete();
		});
		// 회원 정보 변경(이름, 전화번호, 주소)
		function fn_update(){
			$('#update_btn').click(function(){
				if(confirm('수정하시겠습니까?')){
					$('#f').attr('action', 'updateMember.do');
					$('#f').submit();
				}
			});
		}
		// 현재 비밀번호 확인
		var presentPwPass = false;
		function fn_presentPwCheck(){
			$('#pw0').keyup(function(){
				var obj = { // 현재 비밀번호 객체 생성
					pw: $('#pw0').val()
				};
				$.ajax({
					url: 'presentPwCheck.do',
					type: 'post',
					contentType: 'application/json',
					data: JSON.stringify(obj),
					dataType: 'json',
					success: function(resultMap){
						if(resultMap.isCorrect){
							presentPwPass = true;
						} else{
							presentPwPass = false;
						}
					}
				});
			});
		}
		// 비밀번호 변경
		function fn_updatePw(){
			$('#pw_btn').click(function(){
				if(!presentPwPass){
					alert('현재 비밀번호가 일치하지 않습니다. 확인해주세요.');
					$('#pw0').focus();
					return false;
				} else if($('#pw').val() == ''){
					alert('비밀번호를  입력하세요.');
					$('#pw').focus();
					return false;
				} else if($('#pw').val() != $('#pw1').val()){
					alert('새로 입력한 비밀번호가 일치하지 않습니다. 확인해주세요.');
					return false;
				} else{
					$('#f').attr('action', 'updatePw.do');
					$('#f').submit();
				}
			});
		}
		// 회원 탈퇴
		function fn_delete(){
			$('#delete_btn').click(function(){
				if (confirm('탈퇴하시겠습니까?')) {
					location.href = 'deleteMember.do?no=${loginUser.no}';					
				}
			});
		}
	</script>
	<style>
		.menu2{
			width: 600px;
			margin: 50px auto;
			display: flex;
			justify-content: space-between;
			border-bottom: 1px solid gray;
		}
		.menu2 input[type=button]:hover{
			cursor: pointer;
		}
		.board2{
			border: none;
			padding: 5px;
			text-align: center;
			background-color: white;
			color: navy;
			font-size: 15px;
			font-weight: 500;
		}
		.menu2 > a{
			padding: 5px;
			text-decoration: none;
			color: navy;
			font-size: 15px;
			font-weight: 500;
		}
		.myPage_form{
			width: 600px;
			margin: 50px auto;
		}
	</style>
</head>
<body>
	
	<!-- 비로그인  -->
	<c:if test="${loginUser == null}">
		<script type="text/javascript">
		
			alert('아이디와 비밀번호를 확인해주세요');
			history.back();
		
		</script>
	</c:if>
	
	<c:if test="${loginUser != null}">
		<!-- 메뉴 -->
		<div class="menu2">
			<input type="button" class="board2" value="회원정보" onclick="location.href='myPage.do'">
			<input type="button" class="board2" value="갤러리 게시판" onclick="location.href='selectImgBoardList.do'">
			<input type="button" class="board2" value="자유 게시판" onclick="location.href='selectBoardList.do'">
			<input type="button" class="board2" value="로그아웃" onclick="location.href='logout.do'">
			<input type="button" class="board2" value="회원탈퇴" id="delete_btn">
		</div>
		
		<div class="myPage_form">
			<h3>회원정보</h3>
			${loginUser.name}님 반갑습니다!<br><br>
			<form id="f" method="post">
				회원번호<br>
				<input type="text" value="${loginUser.no}" readonly><br>
				
				아이디<br>
				<input type="text" value="${loginUser.id}" readonly><br>
				
				현재 비밀번호<br>
				<input type="password" name="pw0" id="pw0"><br>
				새 비밀번호<br>
				<input type="password" name="pw" id="pw"><br>
				새 비밀번호 확인<br>
				<input type="password" name="pw1" id="pw1"><br>
				<input type="button" id="pw_btn" value="비밀번호 변경하기"><br><br>
				
				이름<br>
				<input type="text" name="name" value="${loginUser.name}"><br><br>
				
				전화번호<br>
				<input type="text" name="phone" value="${loginUser.phone}"><br><br>
				
				이메일<br>
				<input type="text" name="email" value="${loginUser.email}" readonly><br><br>
				
				주소<br>
				<input type="text" name="address" value="${loginUser.address}"><br><br>
				
				<input type="hidden" name="no" value="${loginUser.no}">
				<input type="button" value="정보변경하기" id="update_btn">
			</form>
		</div>
		
	</c:if>
	
</body>
</html>

