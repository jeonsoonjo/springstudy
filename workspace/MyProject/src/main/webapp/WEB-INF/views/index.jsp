<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
			fn_login();
			fn_imgBoard();
			fn_board();
		});
		// 로그인(login)
		function fn_login(){
			$('#f').submit(function(e){
				if($('#id').val() == '' || $('#pw').val() == ''){
					alert('아이디와 비밀번호는 필수입니다.');
					e.preventDefault();
					return false;
				}
			});
		}
		// 회원만 게시판 이용
		function fn_imgBoard(){
			$('.imgBoard').click(function(){
				if($('#id').val() == '' || $('#pw').val() == ''){
					alert('로그인 후 이용하실 수 있습니다.');
					e.preventDefault();
					return false;
				}
			});
		}
		function fn_board(){
			$('.board').click(function(){
				if($('#id').val() == '' || $('#pw').val() == ''){
					alert('로그인 후 이용하실 수 있습니다.');
					e.preventDefault();
					return false;
				}
			});
		}
		
	
	</script>
	<style>
		.menu{
			width: 250px;
			margin: 50px auto;
			display: flex;
			justify-content: space-between;
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
		.login_form{
			width: 300px;
			margin: 50px auto;
			display: flex;
			justify-content: space-between;
		}
		#f input {
			padding: 5px;
			width: 100%;
			height: 30px;
			margin-bottom: 10px;
		}
		#f button {
			margin-top: 20px;
			width: 105%;
			height: 35px;
			line-height: 35px;
			background-color: navy;
			border: none;
			font-size: 15px;
			color: white;
		}
		#f button:hover {
			cursor: pointer;
		}
		.info{
			width: 250px;
			margin: 0 auto;
			display: flex;
			justify-content: space-between;
		}
		.info > a{
			text-decoration: none;
			font-size: 14px;
			text-align: center;
		}
	</style>
</head>
<body>

	<!-- 메뉴 -->
	<div class="menu">
		<input type="button" class="imgBoard board2" value="갤러리 게시판">
		<input type="button" class="board board2" value="자유 게시판">
	</div>
	
	<!-- 로그인 화면 -->
	<div class="login_form">
		<form id="f" action="login.do" method="post">
			<input type="text" name="id" id="id" placeholder="ID">
			<input type="password" name="pw" id="pw" placeholder="Password">
			<button>로그인</button>
		</form>
	</div>
	
	<!-- 회원가입, 아이디&비번 찾기 -->
	<div class="info">
		<a href="joinPage.do">회원가입</a>
		<a href="findIdPage.do">아이디 찾기</a>
		<a href="findPwPage.do">비밀번호 찾기</a>
	</div>
	
</body>
</html>

