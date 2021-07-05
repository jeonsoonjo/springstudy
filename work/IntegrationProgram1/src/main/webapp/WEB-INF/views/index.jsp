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
			fn_selectAll();
			fn_init();
			fn_selectQuery();
		});
		// 초기화
		function fn_init(){
			$('#init_btn').click(function(){
				$('#column').val('');
				$('#query').val('');
				fn_selectAll();
			});
		}
		// 전체 목록 검색
		function fn_selectAll(){
			$.ajax({
				url: 'selectAll.do',
				type: 'get',
				dataType: 'json',
				success: function(resultMap){
					alert(resultMap.message);
					fn_listTable(resultMap.status, resultMap.list);
				}
			});
		}
		// 카테고리 검색
		function fn_selectQuery(){
			$('#search_btn').click(function(){
				if($('#column').val() == ''){
					alert('검색 카테고리를 선택하세요.');
					$('#column').focus();
					return false;
				}
				$.ajax({
					url: 'selectQuery.do',
					type: 'get',
					data: $('#f').serialize(),
					dataType: 'json',
					success: function(resultMap){
						alert(resultMap.message);
						fn_listTable(resultMap.status, resultMap.list);
					}
				});
			});
		}
		
		function fn_listTable(status, list){
			$('#list').empty(); // 시작 전에 비워주기
			if(status == 200){ // 목록이 있을 때
				$.each(list, function(i, searchBoard){
					$('<tr>')
					.append($('<td>').text(searchBoard.title))
					.append($('<td>').text(searchBoard.content))
					.append($('<td>').text(searchBoard.regdate))
					.appendTo('#list');
				});
			} else if(status == 500){ // 목록이 없을 때
				$('<tr>')
				.append($('<td colspan="3">').text('검색 결과 없음'))
				.appendTo('#list');
			}
		}
	</script>
</head>
<body>

	<form id="f" method="get">
		<select id="column" name="column">
			<option value="TITLE" selected>제목</option>
			<option value="CONTENT">내용</option>
		</select>
		<input type="text" id="query" name="query">
		<input type="button" value="검색" id="search_btn">
		<input type="button" value="초기화" id="init_btn">
	</form>
	<br><br>
	
	<table border="1">
		<thead>
			<tr>
				<td>제목</td>
				<td>내용</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody id="list">
			
		</tbody>
	</table>

</body>
</html>

