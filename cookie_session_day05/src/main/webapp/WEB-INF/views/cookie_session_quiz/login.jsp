<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>
<h1>로그인 페이지</h1>
<c:choose>
	<c:when test="${loginUser == null }">
		<form action="quiz_chkUser">
			<input type="text" name="id" placeholder="아이디"><br>
			<input type="password" name="pwd" placeholder="비밀번호"><br>
			<input type="submit" value="로그인">
		</form>
	</c:when>
	<c:otherwise>
		<hr>
		${loginUser }님 로그인 상태입니다<br>
		<a href="quiz_chkUser">main 이동</a>
	</c:otherwise>
</c:choose>

</body>
</html>