<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Sign Up</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
body {
	background-color: #f8f9fa;
}

.signup-container {
	max-width: 500px;
	margin: 50px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>
	<div class="signup-container">
		<h2 class="text-center">Sign Up</h2>
		<%
		if (request.getAttribute("error") != null) {
		%>
		<div class="alert alert-danger"><%=request.getAttribute("error")%></div>
		<%
		}
		%>
		<form action="LoginController" method="post">
			<input type="hidden" name="action" value="signup">
			<div class="form-group">
				<label for="username">Username</label> <input type="text"
					class="form-control" id="username" name="username" required>
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" name="password" required>
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" name="email" required>
			</div>
			<div class="form-group">
				<label for="firstName">First Name</label> <input type="text"
					class="form-control" id="firstName" name="firstName" required>
			</div>
			<div class="form-group">
				<label for="lastName">Last Name</label> <input type="text"
					class="form-control" id="lastName" name="lastName" required>
			</div>
			<button type="submit" class="btn btn-primary btn-block">Sign
				Up</button>
		</form>
		<p class="text-center mt-3">
			Already have an account? <a href="login.jsp">Login</a>
		</p>
	</div>
</body>
</html>