<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Bank Account</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark">
		<a class="navbar-brand" href="#">Banking Application</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/AdminController">Admin
						Dashboard</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/addCustomer.jsp">Add
						New Customer</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/addAccount.jsp">Add
						Bank Account</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/AdminController?action=viewCustomers">View
						Customers</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/AdminController?action=viewTransactions">View
						Transactions</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0"
				action="${pageContext.request.contextPath}/LogoutController"
				method="post">
				<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Logout</button>
			</form>
		</div>
	</nav>
	<div class="container mt-5">
		<h2 class="text-center">Add Bank Account</h2>
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card p-4">
					<c:if test="${not empty error}">
						<div class="alert alert-danger">
							${error}
							<c:if test="${not empty registerLink}">
								<br>
								<a
									href="${pageContext.request.contextPath}/addCustomer.jsp?returnToAccount=true"
									class="btn btn-warning btn-sm mt-2">Register Customer</a>
							</c:if>
						</div>
					</c:if>
					<form
						action="${pageContext.request.contextPath}/AdminController?action=addAccount"
						method="post">
						<div class="form-group">
							<label>Customer ID</label> <input type="number" name="customerId"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Account Type</label> <select name="accountType"
								class="form-control" required>
								<option value="savings">Savings</option>
								<option value="current">Current</option>
							</select>
						</div>
						<div class="form-group">
							<label>Initial Balance</label> <input type="number"
								name="initialBalance" class="form-control" step="0.01" min="0"
								required>
						</div>
						<button type="submit" class="btn btn-primary btn-block">Generate
							Account</button>
						<a href="${pageContext.request.contextPath}/adminHome.jsp"
							class="btn btn-secondary btn-block">Cancel</a>
					</form>
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