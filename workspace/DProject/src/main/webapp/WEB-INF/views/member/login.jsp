<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		// 페이지 로드
		$(document).ready(function(){
			fn_login();
		});
		// 로그인(login)
		function fn_login(){
			$('#f').submit(function(e){
				if($('#id').val() == '' || $('#pw').val() == ''){
					alert('아이디와 비밀번호는 필수입니다.');
					e.preventDefault();
					$('#id').focus();
					return false;
				}
			});
		}
	</script>
</head>
<body>

	<!-- 로그인 화면 -->
	<div class="login_form">
		<form id="f" action="login.do" method="post">
			<input type="text" name="id" id="id" placeholder="ID"><br>
			<input type="password" name="pw" id="pw" placeholder="Password"><br><br>
			<button>로그인</button>
		</form>
	</div>
	
	<!-- 회원가입, 아이디&비번 찾기 -->
	<div class="joinAndFind">
		<a href="joinPage.do">회원가입</a>
		<a href="findIdPage.do">아이디 찾기</a>
		<a href="findPwPage.do">비밀번호 찾기</a>
	</div>

</body>
</html>
