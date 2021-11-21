<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>member02/index.jsp<br>
	<h1>기본 페이지 입니다</h1>
	<h1>request : ${indexKey }</h1>
	<a href="${contextPath }/login02">로그인 페이지</a> <a href="${contextPath }/logout02">로그아웃 페이지</a> 
</body>
</html>