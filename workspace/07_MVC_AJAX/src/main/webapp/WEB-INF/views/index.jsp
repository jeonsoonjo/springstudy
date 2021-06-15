<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			fn1();
			fn2();
		})
		
		// 함수
		function fn1(){
			$('#btn1').click(function(){
				$.ajax({
					url: 'v01', // @RequestMapping(value="v01")
					type: 'get', // @RequestMapping(method=RequestMethod.GET)
					data: 'name=' + $('#name').val() + '&age=' + $('#age').val(), // @RequestParam("name"), @RequestParam("age")
					dataType: 'text', // @RequestMapping(produces="text/plain; charset=utf-8")
					success: function(responseData){ // responseData에 return p로 반환한 String 데이터 저장
						console.log(responseData);
					},
					error: function(xhr, text, error){
						alert('실패');
						// console.log(xhr.responseText + ", " + text + ", " + error);
					}
				})
			})
		}
		
		function fn2(){
			$('#btn2').click(function(){
				$.ajax({
					url: 'v02',
					type: 'get',
					data: $('#f').serialize(), // form의 모든 요소를 한 번에 보낸다
					dataType: 'json',
					success: function(responseData){
						console.log(responseData);
					},
					error: function(xhr, text, error){
						alert('실패');
					}
				})
			})
		}
	</script>
</head>
<body>

	<form id="f">
		<input type="text" name="name" id="name" placeholder="이름"><br>
		<input type="text" name="age" id="age" placeholder="나이"><br>
		<input type="button" id="btn1" value="전송1">
		<input type="button" id="btn2" value="전송2">
	</form>

</body>
</html>

