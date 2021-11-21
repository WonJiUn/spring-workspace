<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>logout.jsp<br>
<h1>request : <%= request.getAttribute("key") %></h1>
<h1>requestScope : ${requestScope.key }</h1>
<h1>request(el) : ${key }</h1>
세개 다 같은 문법이다. 첫번째꺼는 사용하지 않음

</body>
</html>