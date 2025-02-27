<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.time.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Today's Date</title>
</head>
<body>
	<%
	LocalDate onlyDate = LocalDate.now();
	%>
	<b>Today's date is:</b>
	<i><%=onlyDate %></i><br><br>
</body>
</html>