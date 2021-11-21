<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>resultSession.jsp<br>
	id : ${id }, ${sessionScope.id }<br>
	name : ${name }, ${sessionScope.name }<br>
	<hr>
	<a href="make_session">make_session</a>
	<a href="del_session">del_session</a>
	
	<!-- (똑같은 변수명으로 사용했을경우) ${id }는 세션값만 있을때는 ${sessionScope.id }와 동일한 값이 나오지만, 
	model값을 넣어준 뒤에는 model.addAttribute("id", "모델로 저장한 아이디");가 우선적으로 출력됨(${requestScope.id}) -->
</body>
</html>