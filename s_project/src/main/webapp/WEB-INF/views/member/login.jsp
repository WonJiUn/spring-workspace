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
<body>
<jsp:include page="../default/header.jsp" />
	<div class="wrap content">
	<h1>로그인 페이지 입니다</h1>
	<form action="chkUser" method="post">
		<input type="text" name="id" placeholder="아이디"><br>
		<input type="text" name="pw" placeholder="비밀번호"><br>
		<input type="submit" value="로그인">
	</form>
	<a href="${contextPath}/register">회원가입</a><br>
	${msg }<br>
</div>
<jsp:include page="../default/footer.jsp" />
</body>
</html>