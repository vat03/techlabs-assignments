<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome to Banking Application</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center">Welcome to Banking Application</h2>
		<div class="row justify-content-center mt-4">
			<div class="col-md-6">
				<div class="card p-4">
					<div class="card-body text-center">
						<h4 class="card-title">Get Started</h4>
						<p class="card-text">Choose an option below to proceed:</p>
						<a href="${pageContext.request.contextPath}/signup.jsp"
							class="btn btn-primary btn-block mb-2">Sign Up</a> <a
							href="${pageContext.request.contextPath}/login.jsp"
							class="btn btn-secondary btn-block">Login</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"
		integrity="sha384-Qg00WFl9r0Xr6rUqNLvOlwHvQNZuA5ULHNZkvr5rVPf5m2U2PWY0pWwdXYgN0PZ+"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
		integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
		crossorigin="anonymous"></script>
</body>
</html>