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
			fn_email_code();
			fn_email_auth();
		})
		// 이메일 인증코드 받기 : email_code
		function fn_email_code(){
			$('#email_code_btn').click(function(){
				if ($('#email').val() == '') {
					alert('이메일을 입력하세요');
					$('#email').focus();
					return false;
				}
				$.ajax({
					url: 'emailCode.do',
					type: 'get',
					data: 'email=' + $('#email').val(),
					dataType: 'json',
					success: function(resultMap) {
						alert('인증코드가 발송되었습니다.');
						fn_email_auth(resultMap.authCode);
					},
					error: function(xhr, textStatus, errorThrown) {
						
					}
				});
			});
		}
		
		// 이메일 인증 : email_auth
		function fn_email_auth(authCode) {
			$('#email_auth_btn').click(function() {
				if(authCode == $('#user_key').val()) {
					alert('인증되었습니다. 비밀번호 변경 페이지로 이동합니다.');
					$('#f').attr('action', 'changePwPage.do');
					$('#f').submit();
				} else{
					alert('인증에 실패했습니다. 다시 시도해주세요.');
					history.back();
				}
			});
		}
	</script>
</head>
<body>

	<h1>비밀번호 찾기</h1>
	
	<form id="f">
		가입 당시 이메일을 입력하세요.<br>
		<input type="text" name="email" id="email">
		<input type="button" value="인증번호 받기" id="email_code_btn"><br>
		<input type="text" name="user_key" id="user_key">
		<input type="button" value="인증하기" id="email_auth_btn"><br><br>
		<span class="emailAuth_result"></span><br>
		<input type="button" value="돌아가기" onclick="location.href='index.do'">
	</form>

</body>
</html>

