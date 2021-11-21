<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	th{min-width: 100px;}
</style>
</head>
<body>
	<table border="1">
		<tr> 
			<th>id</th> <th>password</th> <th>name</th>
		</tr>
		<c:choose>
			<c:when test="${empty requestScope.list}">
				<tr>
				<th colspan="3">데이터 없음</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${requestScope.list.size()-1 }">
					<tr>
						<td>${requestScope.list[i].id }</td>
						<td>${requestScope.list[i].pwd }</td>
						<td>${requestScope.list[i].name }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="3"><a href="${contextPath }/index">index 이동</a></td>
		</tr>
	</table>
</body>
</html>