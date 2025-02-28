<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form action="LoginController" method="post">
		User Name: <input type="text" name="username"><br>
		<br> Password: <input type="password" name="password"><br><br>
		Login as: <input type="radio" name="loginType" value="Customer"><label
			for="Customer">Customer</label> <input type="radio" name="loginType"
			value="Admin"><label for="Admin">Admin</label> <br> <br>
		<button>Login</button>
	</form>
</body>
</html>