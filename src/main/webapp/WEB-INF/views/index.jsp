<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${msg}</h1>
	
	<form action="login/validate" method="post">
		User : <input type="text" id="user"  name="user"><br>
		<hr>
		Password : <input type="password" id="password" name="password">
		<br>
		<button type="submit"> SUBMIT </button>
	</form>

</body>
</html>