<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>result.jsp<br>
	<h1>${requestScope.method }</h1>
	<h3>name : ${requestScope.name }</h3>
	<h3>age : ${requestScope.age }</h3>
</body>
</html>