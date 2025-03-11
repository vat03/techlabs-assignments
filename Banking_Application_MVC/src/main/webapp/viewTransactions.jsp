<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>View Transactions</title>
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
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/addAccount.jsp">Add
						Bank Account</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/AdminController?action=viewCustomers">View
						Customers</a></li>
				<li class="nav-item active"><a class="nav-link"
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
		<h2 class="text-center">Transaction List</h2>
		<div class="card p-4 mb-4">
			<form method="get"
				action="${pageContext.request.contextPath}/AdminController">
				<input type="hidden" name="action" value="viewTransactions">
				<div class="form-row">
					<div class="col-md-4 form-group">
						<label>Sort By</label> <select name="sortField"
							class="form-control">
							<option value="transaction_id"
								${param.sortField == 'transaction_id' ? 'selected' : ''}>Transaction
								ID</option>
							<option value="sender_account_number"
								${param.sortField == 'sender_account_number' ? 'selected' : ''}>Sender
								Account Number</option>
							<option value="receiver_account_number"
								${param.sortField == 'receiver_account_number' ? 'selected' : ''}>Receiver
								Account Number</option>
							<option value="amount"
								${param.sortField == 'amount' ? 'selected' : ''}>Amount</option>
							<option value="transaction_date"
								${param.sortField == 'transaction_date' ? 'selected' : ''}>Date</option>
							<option value="status"
								${param.sortField == 'status' ? 'selected' : ''}>Status</option>
						</select>
					</div>
					<div class="col-md-4 form-group">
						<label>Order</label> <select name="sortOrder" class="form-control">
							<option value="ASC" ${param.sortOrder == 'ASC' ? 'selected' : ''}>Ascending</option>
							<option value="DESC"
								${param.sortOrder == 'DESC' ? 'selected' : ''}>Descending</option>
						</select>
					</div>
					<div class="col-md-4 form-group align-self-end">
						<button type="submit" class="btn btn-primary btn-block">Apply
							Filter</button>
					</div>
				</div>
			</form>
		</div>
		<div class="card p-4">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Transaction ID</th>
						<th>Sender Account Number</th>
						<th>Receiver Account Number</th>
						<th>Type</th>
						<th>Amount</th>
						<th>Date</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="transaction" items="${transactions}">
						<tr>
							<td>${transaction.transactionId}</td>
							<td>${transaction.senderAccountNumber}</td>
							<td>${transaction.receiverAccountNumber}</td>
							<td>${transaction.transactionType}</td>
							<td>${transaction.amount}</td>
							<td>${transaction.transactionDate}</td>
							<td>${transaction.status}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="${pageContext.request.contextPath}/adminHome.jsp"
				class="btn btn-secondary btn-block">Back</a>
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