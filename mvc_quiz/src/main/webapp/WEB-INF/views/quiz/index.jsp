<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<img src="resources/test/quiz.jpg" width="100px" height="100px">
<img src="css/audio.png" width="100px" height="100px">
<img src="${contextPath }/resources/img.jpg" width="100px" height="100px">
<img src="<c:url value='/resources/img.jpg'/>" width="100px" height="100px">
<img src="resources/img.jpg" width="100px" height="100px"><br>

<p>이미지 경로 조정은 servlet-context.xml에서 할 수 있다</p>

<form action="${contextPath }/loginchk">
	<input type="text" name="inputId" placeholder="id"><br>
	<input type="password" name="inputPwd" placeholder="password"><br>
	<input type="submit" value="login">
</form>

<a href="${contextPath }/regist">회원가입</a> 
<a href="${contextPath }/member_view">모든 회원보기</a>
</body>
</html>