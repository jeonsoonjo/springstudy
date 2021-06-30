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
			fn_search();
			fn_init();
			fn_search_all();
		});
		
		function fn_search(){
			$('#search_btn').click(function(){
				$('#f').attr('action', 'search.do');
				$('#f').submit();
			});
		}
		
		function fn_init(){
			$('#column').val('');
			$('#query').val('');
		}
		
		function fn_search_all(){
			$('#search_all_btn').click(function(){
				location.href = 'searchAll.do';
			});
		}
	</script>
</head>
<body>

	<!-- 검색화면 -->
	<form id="f" action="" method="get">
		<select name="column" id="column">
			<option value="">:::선택:::</option>
			<option value="EMPLOYEE_ID">EMPLOYEE_ID</option>
			<option value="LAST_NAME">LAST_NAME</option>
		</select>
		<input type="text" name="query" id="query">
		<input type="button" value="검색" id="search_btn">
		<input type="button" value="초기화" id="init_btn">
		<input type="button" value="전체조회" id="search_all_btn">
	</form>
	<br><hr><br>
	
</body>
</html>

