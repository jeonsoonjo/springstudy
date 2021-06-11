<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

	<h1>Hello world!</h1>
	
	<P>The time on the server is ${serverTime}.</P>
	<img src="/mvc01/resources/dog.jpg" alt="dog">
	<br>
	<!-- context-Path : mvc01을 꼭 작성해야 한다 -->
	
	<img src="/mvc01/assets/image/lion.jpg" alt="lion">
	<!-- 
		http://localhost:9090/mvc01/assets/image/lion.jpg
		경로가 맞는데 화면에 나오지 않는다. 이유는 servlet-context.xml에 경로를 지정해 주지 않았기 때문!
		즉, 경로를 잡을 때에는 servlet-context.xml에서 resources(자원)을 추가해야 한다
	-->
	
</body>
</html>


