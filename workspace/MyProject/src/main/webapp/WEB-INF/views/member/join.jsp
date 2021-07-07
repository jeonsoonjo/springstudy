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
			fn_idCheck();
			fn_pwCheck();
			fn_pwCheck2();
			fn_emailCheck();
			fn_email_code();
			fn_join();
		});
		
		// 아이디 중복체크(idCheck)
		var idPass = false;
		function fn_idCheck(){
			$('#id').keyup(function(){
				var regID = /^[a-z]{3,6}$/; // ^[a-z][a-z0-9_-]{4,19}$
				if(!regID.test($('#id').val())){
					$('.id_result').text('아이디는 영어 소문자 3~6자리만 입력 가능합니다.');
					// 아이디는 영어 소문자(a~z)로 시작하고, 소문자/숫자(0~9)/특수기호(_, -) 포함 5~20자 입니다.
					return false;
				}
				$.ajax({
					url: 'idCheck.do',
					type: 'get',
					data: 'id=' + $('#id').val(),
					dataType: 'json',
					success: function(res){
						if(res.count == 0){
							$('.id_result').text('사용 가능한 아이디입니다.');
							idPass = true;
						} else{
							$('.id_result').text('이미 사용 중인 아이디입니다.');
							idPass = false;
						}
					},
					error: function(xhr, textStatus, errorThrown) {
						
					}
				});
			});
		}
		// 비밀번호 검증(pwCheck)
		var pwPass = false;
		function fn_pwCheck(){
			$('#pw').keyup(function(){
				var regPW = /^[0-9]{4}$/; // ^[A-Za-z0-9`~!@#$%^&*]{4,19}$
				if(regPW.test($('#pw').val())){
					$('.pw_result').text('사용 가능한 비밀번호입니다.');
					pwPass = true;
				} else{
					$('.pw_result').text('비밀번호는 숫자(0~9) 4자리만 입력 가능합니다.');
					// 비밀번호는 영어 대,소문자/숫자/특수기호 포함 5~20자리 입니다.
					pwPass = false;
				}
			});
		}
		// 비밀번호 확인 검증(pwCheck2)
		var pwPass2 = false;
		function fn_pwCheck2(){
			$('#pw2').keyup(function(){
				if($('#pw').val() == $('#pw2').val()){
					$('.pw2_result').text('비밀번호가 일치합니다.');
					pwPass2 = true;
				} else{
					$('.pw2_result').text('비밀번호가 일치하지 않습니다. 비밀번호를 확인하세요.');
					pwPass2 = false;
				}
			});
		}
		// 이메일 중복 체크
		var emailPass = false;
		function fn_emailCheck(){
			$('#email').keyup(function(){
				$.ajax({
					url: 'emailCheck.do',
					type: 'get',
					data: 'email=' + $('#email').val(),
					dataType: 'json',
					success: function(res){
						if(res.count == 0){
							$('.email_result').text('사용 가능한 이메일입니다.');
							emailPass = true;
						} else{
							$('.email_result').text('이미 사용 중인 아이디입니다.');
							emailPass = false;
						}
					},
					error: function(xhr, textStatus, errorThrown) {
						
					}
				});
			})
			
		}
		// 이메일 인증코드 받기 : email_code
		// 이메일 인증코드 받기(root-context에서 이메일 bean 생성)
		function fn_email_code(){
			$('#email_code_btn').click(function(){
				if($('#email').val() == ''){
					alert('이메일을 입력하세요.');
					$('#email').focus();
					return false;
				}
				$.ajax({
					url: 'emailCode.do',
					type: 'get',
					data: 'email=' + $('#email').val(),
					dataType: 'json',
					success: function(resultMap){
						alert('인증번호가 발송되었습니다.');
						fn_email_auth(resultMap.authCode);
					},
					error: function(xhr, textStatus, errorThrown) {
						
					}
				});
			});
		}
		// 이메일 인증 : email_auth
		var authPass = false;
		function fn_email_auth(authCode){
			$('#email_auth_btn').click(function(){
				if(authCode == $('#user_key').val()){
					$('.emailAuth_result').text('인증되었습니다.');
					authPass = true;
				} else{
					$('.emailAuth_result').text('인증에 실패했습니다. 다시 시도해주세요.');
					$('#email').val() = '';
					authPass = false;
				}
			});
		}
		// 회원가입(join)
		function fn_join() {
			$('#join_btn').click(function(){
				if($('#id').val() == '' ||
				   $('#pw').val() == '' ||
				   $('#pw2').val() == '' ||
				   $('#name').val() == '' ||
				   $('#phone').val() == '' ||
				   $('#email').val() == '' ||
				   $('#address').val() == ''){
					   alert('가입내용을 입력하세요.');
					   return false;
				} else {
					$('#f').attr('action', 'join.do');
					$('#f').submit();
				}
			});
		}
	</script>
	<style>
		.join_form{
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
		.naming{
			font-size: 13px;
		}
		#f input[type=button] {
			margin-top: 20px;
			width: 105%;
			height: 30px;
			line-height: 25px;
			background-color: navy;
			border: none;
			font-size: 15px;
			color: white;
		}
		#f button:hover {
			cursor: pointer;
		}
	</style>
</head>
<body>
	
	<!-- 회원가입 화면  -->
	<div class="join_form">
		<form id="f" method="post">
			<span class="naming">아이디</span><br>
			<input type="text" name="id" id="id">
			<span class="id_result"></span>
			
			<span class="naming">비밀번호</span><br>
			<input type="password" name="pw" id="pw">
			<span class="pw_result"></span>
			
			<span class="naming">비밀번호 확인</span><br>
			<input type="password" name="pw2" id="pw2">
			<span class="pw2_result"></span>
			
			<span class="naming">이름</span><br>
			<input type="text" name="name" id="name">
			
			<span class="naming">전화번호</span><br>
			<input type="text" name="phone" id="phone">
	
			<span class="naming">이메일</span><br>
			<input type="text" name="email" id="email">
			<span class="email_result"></span><br>
			<input type="button" value="인증번호 받기" id="email_code_btn"><br>
			<input type="text" name="user_key" id="user_key">
			<input type="button" value="인증하기" id="email_auth_btn"><br>
			<span class="emailAuth_result"></span><br>
			
			<span class="naming">주소</span><br>
			<input type="text" name="address" id="address">
			
			<input type="button" value="가입하기" id="join_btn">
			<input type="button" value="돌아가기" onclick="location.href='index.do'">
		</form>
	</div>

</body>
</html>

