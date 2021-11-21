<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	th{min-width: 150px;}
</style>
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
			
			<table>
			<caption><h1>${personal.id } 정 보</h1></caption>
				<tr>
					<th>아이디</th> <th>${personal.id }</th>
				</tr>
				<tr>
					<th>비밀번호</th> <th>${personal.pw }</th>
				</tr>
				<tr>
					<th>주소</th> <th>${personal.addr }</th>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
	
</div>
<jsp:include page="../default/footer.jsp" />
</body>
</html>