<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>홈페이지</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
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
			})
		}
	</script>
</head>
<body>

	<h1>홈페이지</h1>
	
	<form action="login.do" id="f" method="post">
		아이디<br>
		<input type="text" name="id" id="id" placeholder="ID"><br><br>
		비밀번호<br>
		<input type="password" name="pw" id="pw" placeholder="Password"><br><br>
		<button>로그인</button>
		<a href="joinPage.do">회원가입</a>
	</form>
	
</body>
</html>

