<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
body {
	background-color: #f8f9fa;
}

.login-container {
	max-width: 400px;
	margin: 100px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>
	<div class="login-container">
		<h2 class="text-center">Login</h2>
		<%
		if (request.getAttribute("error") != null) {
		%>
		<div class="alert alert-danger"><%=request.getAttribute("error")%></div>
		<%
		}
		%>
		<form action="LoginController" method="post">
			<input type="hidden" name="action" value="login">
			<div class="form-group">
				<label for="username">Username</label> <input type="text"
					class="form-control" id="username" name="username" required>
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" name="password" required>
			</div>
			<button type="submit" class="btn btn-primary btn-block">Login</button>
		</form>
		<p class="text-center mt-3">
			Don't have an account? <a href="signup.jsp">Sign Up</a>
		</p>
	</div>
</body>
</html>