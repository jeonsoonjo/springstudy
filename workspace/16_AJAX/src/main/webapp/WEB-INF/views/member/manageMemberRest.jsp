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
			fn_selectMemberList();
			fn_paging();
			fn_selectMemberByNo();
			fn_insertMember();
			fn_updateMember();
			fn_deleteMember();
			fn_init();
		});
		
		// 1. 회원 목록
		var page = 1; // 전역변수  page는 페이징을 클릭하면 fn_paging()에 의해서 값이 변한다
		function fn_selectMemberList(){
			$.ajax({
				url: 'member',
				type: 'get',
				data: 'page=' + page,
				dataType: 'json',
				success: function(resultMap){
					// 1-1. 목록 만들기
					$('#member_list').empty(); // 기존 회원 목록 초기화
					if(resultMap.exists){
						// resultMap.list 출력
						$.each(resultMap.list, function(i, member){
							$('<tr>')
							.append($('<td>').text(member.id))
							.append($('<td>').text(member.name))
							.append($('<td>').text(member.address))
							.append($('<td>').text(member.gender))
							.append($('<td>').html('<input type="hidden" name="no" id="no" value="' + member.no + '"><input type="button" value="조회" id="view_btn">'))
							.appendTo('#member_list');
						});
					} else{
						$('<tr>')
						.append('<td colspan="5">등록된 회원이 없습니다.</td>')
						.appendTo('#member_list');
					}
					// 1-2. 페이징 만들기
					var paging = resultMap.paging;
					$('#paging').empty(); // 기존 페이징 초기화
					// 1) 이전
					if(paging.beginPage <= paging.pagePerBlock){ // 이전 페이지가 없을 때(1페이지)
						$('<div>')
						.addClass('disable')
						.text('◀')
						.appendTo('#paging');
					} else{ // 이전 페이지가 있을 때
						$('<div>')
						.addClass('previous_block').addClass('link')
						.attr('data-page', paging.beginPage - 1)
						.text('◀')
						.appendTo('#paging');
					}
					// 2) 페이지 번호(1, 2, 3, 4, 5)
					for(let p=paging.beginPage; p<=paging.endPage; p++){
						if(p == paging.page){ // 표시된 페이지가 현재 페이지(링크 없음을 의미)
							$('<div>')
							.addClass('now_page')
							.text(p)
							.appendTo('#paging');
						} else{
							$('<div>')
							.addClass('go_page').addClass('link')
							.attr('data-page', p)
							.text(p)
							.appendTo('#paging');
						}
					}
					// 3) 다음
					if(paging.endPage == paging.totalPage){ // 다음 페이지가 없을 때(마지막 페이지)
						$('<div>')
						.addClass('disable')
						.text('▶')
						.appendTo('#paging');
					} else{ //  다음 페이지가 있을 때
						$('<div>')
						.addClass('next_block').addClass('link')
						.attr('data-page', paging.endPage + 1)
						.text('▶')
						.appendTo('#paging');
					}
				}
			});
		}
		
		// 2. 회원 목록 페이징(페이징 링크 처리)
		function fn_paging(){
			$('body').on('click', '.previous_block', function(){ // 위에서 동적으로 만들어진 함수는 $('#') 사용할 수 없다
				page = $(this).attr('data-page');
				fn_selectMemberList();
			});
			$('body').on('click', '.go_page', function(){
				page = $(this).attr('data-page');
				fn_selectMemberList();
			});
			$('body').on('click', '.next_block', function(){
				page = $(this).attr('data-page');
				fn_selectMemberList();
			});
		}
		
		// 3. 회원 정보 보기
		function fn_selectMemberByNo(){
			$('body').on('click', '#view_btn', function(){
				$('input:text[name="id"]').attr('readonly', true);
				$.ajax({
					url: 'member/' + $(this).prev().val(),
					type: 'get',
					dataType: 'json',
					success: function(resultMap){
						if(resultMap.exists){
							$('input:text[name="id"]').val(resultMap.member.id);
							$('input:text[name="name"]').val(resultMap.member.name);
							$('input:text[name="address"]').val(resultMap.member.address);
							$('input:radio[name="gender"][value="' + resultMap.member.gender + '"]').prop('checked', true);
							$('#view_area input:hidden[name="no"]').val(resultMap.member.no);
						} else{
							alert(obj.no + '번 회원 정보는 없습니다.');
						}
					}
				});
			});
		}
		
		// 4. 회원 등록
		function fn_insertMember(){
			$('#insert_btn').click(function(){
				var member = { // java 객체로 만들고 ajax에서 JSON.stringify()로 JSON처리
					id: $('#id').val(),
					name: $('#name').val(),
					address: $('#address').val(),
					gender: $('input:radio[name="gender"]:checked').val()
				};
				$.ajax({
					url: 'member',
					type: 'post',
					contentType: 'application/json',
					data: JSON.stringify(member), 
					success: function(resultMap){
						if(resultMap.result > 0){
							alert('새로운 회원이 등록되었습니다.');
							fn_selectMemberList();
						}
					},
					error: function(xhr, testStatus, errorThrown){
						switch(xhr.status){
						case 1001:
							alert(xhr.responseText);
							break;
						}
					}
				});
			});
		}
		
		// 5. 회원 수정
		function fn_updateMember(){
			$('#update_btn').click(function(){
				var obj = {
					id: $('input:text[name="id"]').val(),
					name: $('input:text[name="name"]').val(),
					address: $('input:text[name="address"]').val(),
					gender: $('input:radio[name="gender"]:checked').val(),
					no: $('#view_area input:hidden[name="no"]').val()
				};
				// console.log(obj);
				$.ajax({
					url: 'member',
					type: 'put',
					contentType: 'application/json',
					data: JSON.stringify(obj),
					success: function(resultMap){
						if(resultMap.count > 0){
							alert('회원 정보가 수정되었습니다.');
							fn_selectMemberList();
						} else{
							alert('회원 정보가 수정되지 않았습니다.');
						}
					}
				});
			});
		}
		
		// 6. 회원 삭제
		function fn_deleteMember(){
			$('#delete_btn').click(function(){
				if(!confirm('삭제할까요?')){
					return false;
				}
				$.ajax({
					url: 'member/' + $('#view_area input:hidden[name="no"]').val(),
					type: 'delete',
					dataType: 'json',
					success: function(resultMap){
						if(resultMap.count > 0){
							alert('회원 정보가 삭제되었습니다.');
							fn_selectMemberList();
							$('input:text[name="id"]').val('').attr('readonly', false);
							$('input:text[name="name"]').val('');
							$('input:text[name="address"]').val('');
							$('input:radio[name="gender"]').prop('checked', false);
						} else{
							alert('회원 정보가 삭제되지 않았습니다.');
						}
					}
				});
			});
		}
		
		// 7. 초기화
		function fn_init(){
			$('#init_btn').click(function(){
				$('input:text[name="id"]').val('').attr('readonly', false);
				$('input:text[name="name"]').val('');
				$('input:text[name="address"]').val('');
				$('input:radio[name="gender"]').prop('checked', false);
			});
		}
	</script>
	<style>
		#paging{
			width: 50%;
			margin: 0 auto;
			display: flex;
			justify-content: space-between;
			text-align: center;
		}
		#paging div{
			width: 40px;
			height: 20px;
		}
		.disable{
			color: silver;
		}
		.link{
			cursor: pointer;
		}
		.now_page{
			color: limegreen;
		}
	</style>
</head>
<body>

	<h1>회원 관리</h1>
	
	<div id="view_area">
		아이디 <input type="text" name="id" id="id"><br>
		이름 <input type="text" name="name" id="name"><br>
		주소 <input type="text" name="address" id="address"><br>
		성별
		<input type="radio" name="gender" id="male" value="남"><label for="male">남</label>
		<input type="radio" name="gender" id="female" value="여"><label for="female">여</label><br>
		<input type="hidden" name="no">
		<input type="reset" id="init_btn" value="초기화">
		<input type="button" id="insert_btn" value="등록">
		<input type="button" id="update_btn" value="수정">
		<input type="button" id="delete_btn" value="삭제"><br>
	</div>
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>주소</td>
				<td>성별</td>
				<td></td>
			</tr>
		</thead>
		
		<tbody id="member_list">
			
		</tbody>
		
		<tfoot>
			<tr>
				<td colspan="5">
					<div id="paging"></div>
				</td>
			</tr>
		</tfoot>
	</table>
	
</body>
</html>

