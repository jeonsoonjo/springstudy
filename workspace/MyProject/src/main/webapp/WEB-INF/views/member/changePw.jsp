<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		// 페이지 로드
		$(document).ready(function(){
			fn_changePw();
		})
		// 비밀번호 변경
		function fn_changePw(){
			$('#change_pw_btn').click(function(){
				var regPW = /^[0-9]{4}$/;
				if(!regPW.test($('#pw').val())){
					alert('비밀번호는 숫자(0~9) 4자리만 입력 가능합니다.');
					$('#pw').focus();
					return false;
				} else if($('#pw').val() != $('#pw2').val()){
					alert('새로 입력한 비밀번호가 일치하지 않습니다. 확인해주세요.');
					return false;
				} else{
					$('#f').attr('action', 'changePw.do');
					$('#f').submit();
				}
			});
		}
	</script>
</head>
<body>

	<h1>비밀번호 변경</h1>
	
	<form id="f" method="post">
		<input type="hidden" name="email" value="${email}">
		새 비밀번호<br>
		<input type="password" name="pw" id="pw"><br><br>
		비밀번호 확인<br>
		<input type="password" name="pw2" id="pw2"><br><br>
		<input type="button" id="change_pw_btn" value="비밀번호 변경">
		<input type="button" value="돌아가기" onclick="location.href='index.do'">
	</form>

</body>
</html>

