<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>New Transaction</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script>
	function toggleReceiverField() {
		const actionType = document.getElementById("actionType").value;
		const receiverDiv = document.getElementById("receiverDiv");
		receiverDiv.style.display = (actionType === "transfer") ? "block"
				: "none";
	}
</script>
</head>
<body onload="toggleReceiverField()">
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
					href="${pageContext.request.contextPath}/CustomerController">Customer
						Dashboard</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/CustomerController?action=passbook">Passbook</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/newTransaction.jsp">New
						Transaction</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/CustomerController?action=editProfile">Edit
						Profile</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0"
				action="${pageContext.request.contextPath}/LogoutController"
				method="post">
				<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Logout</button>
			</form>
		</div>
	</nav>
	<div class="container">
		<h2 class="mt-5">New Transaction</h2>
		<c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert">${error}</div>
		</c:if>
		<form
			action="${pageContext.request.contextPath}/TransactionController?action=newTransaction"
			method="post" class="mt-3">
			<div class="form-group">
				<label for="actionType">What would you like to do?</label> <select
					id="actionType" name="actionType" class="form-control"
					onchange="toggleReceiverField()" required>
					<option value="transfer">Transfer Money to Another Account</option>
					<option value="withdraw">Withdraw Money from Own Account</option>
					<option value="add">Deposit Money in Own Account</option>
				</select>
			</div>
			<div id="receiverDiv" class="form-group" style="display: none;">
				<label>Receiver Account Number</label> <input type="text"
					name="receiverAccountNumber" class="form-control">
			</div>
			<div class="form-group">
				<label>Amount</label> <input type="number" name="amount"
					class="form-control" step="0.01" required>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="${pageContext.request.contextPath}/customerHome.jsp"
				class="btn btn-secondary">Cancel</a>
		</form>
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
