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

	function fn_init(){
		$('#init_btn').click(function(){
			$('#column').val('');
			$('#query').val('');
			fn_selectAll();
		});
	}
	
	function fn_selectAll(){
		$.ajax({
			url: 'selectAll.do',
			type: 'post',
			dataType: 'json',
			success: function(resultMap){
				alert(resultMap.message);
				fn_listTable(resultMap.status, resultMap.list);
			}
		});
	}
	
	function fn_selectQuery(){
		$('#search_btn').click(function(){
			if($('#column').val() == ''){
				alert('검색 카테고리를 선택하세요.');
				$('#column').focus();
				return false;
			}
			$.ajax({
				url: 'selectQuery.do',
				type: 'post',
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
			$.each(list, function(i, staff){
				$('<tr>')
				.append($('<td>').text(staff.no))
				.append($('<td>').text(staff.name))
				.append($('<td>').text(staff.depart))
				.append($('<td>').text(staff.salary))
				.append($('<td>').text(staff.regdate))
				.appendTo('#list');
			});
		} else if(status == 500){ // 목록이 없을 때
			$('<tr>')
			.append($('<td colspan="5">').text('없음'))
			.appendTo('#list');
		}
	}
	</script>
</head>
<body>

	<form id="f" method="post">
		<select id="column" name="column">
			<option value="">:::::선택:::::</option>
			<option value="NAME">이름</option>
			<option value="DEPART">부서</option>
			<option value="SALARY">연봉</option>
			<option value="BOTH">이름+부서</option>
		</select>
		<input type="text" id="query" name="query">
		<input type="button" value="검색" id="search_btn">
		<input type="button" value="초기화" id="init_btn">
	</form>
	<br><br>
	
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>부서</td>
				<td>연봉</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody id="list">
			
		</tbody>
	</table>

</body>
</html>

