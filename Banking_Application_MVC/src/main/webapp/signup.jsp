<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up - Banking Application</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
<script>
	function toggleAdminCode() {
		const userType = document.getElementById("userType").value;
		const adminCodeDiv = document.getElementById("adminCodeDiv");
		if (userType === "admin") {
			adminCodeDiv.style.display = "block";
			document.getElementById("adminCode").setAttribute("required",
					"required");
		} else {
			adminCodeDiv.style.display = "none";
			document.getElementById("adminCode").removeAttribute("required");
		}
	}
</script>
</head>
<body onload="toggleAdminCode()">
	<div class="container mt-5">
		<h2 class="text-center">Sign Up</h2>
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card p-4">
					<c:if test="${not empty error}">
						<div class="alert alert-danger">${error}</div>
					</c:if>
					<form action="${pageContext.request.contextPath}/LoginController"
						method="post">
						<input type="hidden" name="action" value="signup">
						<div class="form-group">
							<label for="userType">Sign Up As</label> <select id="userType"
								name="userType" class="form-control"
								onchange="toggleAdminCode()" required>
								<option value="customer">Customer</option>
								<option value="admin">Admin</option>
							</select>
						</div>
						<div id="adminCodeDiv" style="display: none;" class="form-group">
							<label for="adminCode">Admin Signup Code</label> <input
								type="text" id="adminCode" name="adminCode" class="form-control"
								placeholder="Enter code">
						</div>
						<div class="form-group">
							<label for="username">Username</label> <input type="text"
								id="username" name="username" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								id="password" name="password" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="email">Email ID</label> <input type="email"
								id="email" name="email" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="firstName">First Name</label> <input type="text"
								id="firstName" name="firstName" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="lastName">Last Name</label> <input type="text"
								id="lastName" name="lastName" class="form-control" required>
						</div>
						<button type="submit" class="btn btn-primary btn-block">Sign
							Up</button>
						<a href="${pageContext.request.contextPath}/welcome.jsp"
							class="btn btn-secondary btn-block">Cancel</a>
					</form>
					<p class="mt-3 text-center">
						Already have an account? <a
							href="${pageContext.request.contextPath}/login.jsp">Login
							here</a>
					</p>
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