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
</head>
<body>
	<div class="container">
		<h2 class="mt-5">New Transaction</h2>
		<form
			action="${pageContext.request.contextPath}/transaction?action=newTransaction"
			method="post" class="mt-3">
			<div class="form-group">
				<label>Sender Account ID</label> <input type="number"
					name="senderAccountId" class="form-control" required>
			</div>
			<div class="form-group">
				<label>Receiver Account ID</label> <input type="number"
					name="receiverAccountId" class="form-control" required>
			</div>
			<div class="form-group">
				<label>Type of Transaction</label> <select name="transactionType"
					class="form-control" required>
					<option value="credit">Credit</option>
					<option value="debit">Debit</option>
					<option value="transfer">Transfer</option>
				</select>
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