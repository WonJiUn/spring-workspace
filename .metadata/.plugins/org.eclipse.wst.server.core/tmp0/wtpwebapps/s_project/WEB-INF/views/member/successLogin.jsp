<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../default/header.jsp" />
	<div class="wrap content">
	<c:choose>
		<c:when test="${empty loginUser }">
			<script type="text/javascript">
				alert('로그인해주세요')
				location.href='login';
			</script>
		</c:when>
		<c:otherwise>
			<h1>로그인 성공</h1>
			${loginUser } 님 환영합니다
		</c:otherwise>
	</c:choose>
	
	</div>
<jsp:include page="../default/footer.jsp" />
</body>
</html>