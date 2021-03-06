<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function ajax(){
		//n, a 둘중에 어떤 방식을 써도 됨
		var n = $("#name").val();
		var a = document.getElementById("age").value;
		var addr = $("#addr").val();
		var form = { age:a, name:n, addr:addr }
		console.log(form)
		
		$.ajax({
			url : "ajax_result01",
			type : "POST",
			data : JSON.stringify(form),	
			//data : 서버로 보낼 데이터. pom.xml에 추가해야 사용가능. object타입의 form을 string으로 변환해서 보냄
			dataType : "json",	
			//서버로 돌려받는 값의 타입 지정(json) - 키:값 으로 이루어진 map과 비슷하다고 생각하면 됨
			contentType : "application/json; charset=utf-8",
			//서버로 보낼 데이터 설정(json, utf-8)
			success : function(result){
				$("#label").text(result.name + " : " + result.age + " : " + result.addr)
			}, error : function(){ alert("문제 발생") }
		})
	}
</script>
</head>
<body>
	<input type="text" id="name" placeholder="이름"><br>
	<input type="text" id="age" placeholder="나이"><br>
	<input type="text" id="addr" placeholder="주소"><br>
	<input type="button" onclick="ajax()" value="저장">
	<hr> 결과 : <label id="label"></label>
</body>
</html>