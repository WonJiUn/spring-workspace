<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>main.jsp<br>
<c:choose>
	<c:when test="${loginUser == null}">
		<script type="text/javascript">
			alert('로그인해라(현재 동작안함. 이유는 알수없음)')
			location.href='quiz_login'
		</script>
	</c:when>
	<c:otherwise>
		${loginUser }님 환영합니다<br>
		<a href="quiz_login">login</a>
		<a href="quiz_logout">logout</a>
	</c:otherwise>
</c:choose>
	
</body>
</html>