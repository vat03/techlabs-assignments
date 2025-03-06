<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>View Customers</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
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
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/addAccount.jsp">Add
						Bank Account</a></li>
				<li class="nav-item active"><a class="nav-link"
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
	<div class="container">
		<h2 class="mt-5">Customer List</h2>
		<form class="mt-3" method="get"
			action="${pageContext.request.contextPath}/AdminController">
			<input type="hidden" name="action" value="viewCustomers">
			<div class="form-row">
				<div class="col-md-4">
					<label>Sort By</label> <select name="sortField"
						class="form-control">
						<option value="customer_id"
							${param.sortField == 'customer_id' ? 'selected' : ''}>Customer
							ID</option>
						<option value="first_name"
							${param.sortField == 'first_name' ? 'selected' : ''}>First
							Name</option>
						<option value="last_name"
							${param.sortField == 'last_name' ? 'selected' : ''}>Last
							Name</option>
						<option value="balance"
							${param.sortField == 'balance' ? 'selected' : ''}>Balance</option>
					</select>
				</div>
				<div class="col-md-4">
					<label>Order</label> <select name="sortOrder" class="form-control">
						<option value="ASC" ${param.sortOrder == 'ASC' ? 'selected' : ''}>Ascending</option>
						<option value="DESC"
							${param.sortOrder == 'DESC' ? 'selected' : ''}>Descending</option>
					</select>
				</div>
				<div class="col-md-4 align-self-end">
					<button type="submit" class="btn btn-primary">Apply Filter</button>
				</div>
			</div>
		</form>
		<table class="table table-striped mt-3">
			<thead>
				<tr>
					<th>Customer ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Account Number(s)</th>
					<th>Account Type(s)</th>
					<th>Balance(s)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${customers}">
					<tr>
						<td>${customer.customerId}</td>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td><c:choose>
								<c:when test="${empty customer.accounts}">
									NA
								</c:when>
								<c:otherwise>
									<c:forEach var="account" items="${customer.accounts}">
										${account.accountNumber}<br>
									</c:forEach>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${empty customer.accounts}">
									NA
								</c:when>
								<c:otherwise>
									<c:forEach var="account" items="${customer.accounts}">
										${account.accountType}<br>
									</c:forEach>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${empty customer.accounts}">
									NA
								</c:when>
								<c:otherwise>
									<c:forEach var="account" items="${customer.accounts}">
										${account.balance}<br>
									</c:forEach>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="${pageContext.request.contextPath}/adminHome.jsp"
			class="btn btn-secondary">Back</a>
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
