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
<body>member02/login.jsp<br>
	<h1>로그인 페이지 입니다</h1>
	<h1>el 표기법 : ${requestScope.loginKey }</h1>
	<a href="${contextPath }/logout02">로그아웃 페이지</a> <a href="${contextPath }/index02">기본 페이지</a> 
</body>
</html>