<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			fn_login();
		});
		
		function fn_login(){
			$('#f').submit(function(e){
				if($('#id').val() == '' || $('#pw').val() == ''){
					alert('아이디와 비밀번호는 필수입니다.');
					e.preventDefault();
					return false;
				}
			});
		}
	</script>
</head>
<body>

	<form id="f" action="login.do" method="post">
		<span class="naming">아이디</span><br>
		<input type="text" name="id" id="id" placeholder="ID"><br><br>
		<span class="naming">비밀번호</span><br>
		<input type="password" name="pw" id="pw" placeholder="Password"><br><br>
		<button>로그인</button>
	</form>
	<br>
	
	<a href="joinPage.do">회원가입</a>
	<a href="findIdPage.do">아이디 찾기</a>
	<a href="findPwPage.do">비밀번호 찾기</a>
	
</body>
</html>

