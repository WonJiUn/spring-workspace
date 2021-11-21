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
	a{color: black;}
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
		
		<table border="1">
		<caption><h1>회 원 정 보</h1></caption>
			<tr> <th>아이디</th> <th>비밀번호</th> <th>주소</th> </tr>
			<c:forEach var="mem" items="${list }">
				<tr>
					<td><a href="${contextPath }/info?id=${mem.id}">${mem.id }</a></td> 
					
					<td>${mem.pw }</td> <td>${mem.addr }</td>
				</tr>
			</c:forEach>
		</table>
		</c:otherwise>
	</c:choose>
	</div>
<jsp:include page="../default/footer.jsp" />
</body>
</html>