<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/myapp/member/update" method="POST">
		ID : <input type="text" name="id" readonly value="${loginM.id}"><br>
		PW : <input type="password" name="pw"><br>
		NICK : <input type="text" name="nick" value="${loginM.nick}"><br>
		<input type="submit" value="UPDATE">
	</form>
</body>
</html>