<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../default/header.jsp" />
	<div class="wrap content">
	<h1>회원등록</h1>
	<table border="1">
		<tr>
			<td>
			<form action="insert" method="post">
			<input type="text" name="id" placeholder="아이디"><br>
			<input type="text" name="pw" placeholder="비밀번호"><br>
			<input type="text" name="addr" placeholder="주 소"><br>
			<input type="submit" value="회원가입">
			</form>
			</td>
		</tr>
	</table>
	</div>
<jsp:include page="../default/footer.jsp" />
</body>
</html>