<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<!-- contextPath에 /가 있는 경우 : contextPath는 슬래시로 시작해야 한다 -->
	<form action="/mvc04/v01">
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="age" placeholder="나이"><br><br>
		<button>전송</button>
	</form>

	<!-- contextPath에 /가 없는 경우 : 디렉터리(폴더)로 인식하여 오류 발생 -->
	<form action="mvc04/v01"> 
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="age" placeholder="나이"><br><br>
		<button>전송</button>
	</form>
	
	<!-- 매핑값에 /가 있는 경우 : 오류 -->
	<form action="/v01"> 
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="age" placeholder="나이"><br><br>
		<button>전송</button>
	</form>
	
	<!-- 매핑값에 /가 없는 경우 : 정상 -->
	<form action="v01"> 
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="age" placeholder="나이"><br><br>
		<button>전송</button>
	</form>
	
	<!-- 결론.
		1. 슬래시로 시작하려면 contextPath부터 작성한다
		2. 슬래시 없이 시작하려면 매핑값만 작성한다
	-->
	
	
	<!-- 새로운 매핑 -->
	<h2>v02 매핑</h2>
	<form action="v02">
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="age" placeholder="나이"><br><br>
		<button>전송</button>
	</form>
	
	<h2>v04 매핑</h2>
	<form action="v04">
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="age" placeholder="나이"><br><br>
		<button>전송</button>
	</form>
	
	<h2>v06 매핑</h2>
	<form action="v06">
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="age" placeholder="나이"><br><br>
		<button>전송</button>
	</form>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>

