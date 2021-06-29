<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 상단 --%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="layout/header.jsp">
	<jsp:param value="홈페이지제목" name="title" />
</jsp:include>


<%-- 하단 --%>
<%@ include file="layout/footer.jsp" %>		

