<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- This is comment tag --%>
<title>First JSP Page</title>
</head>
<body>
	<p>Welcome to JSP</p>
	<%-- Declaration Tag --%>
	<%-- Used to declare variables --%>
	<%!String name = "Vatsal";
	String greet = "Hello";
	String concat = "";%>
	<%-- Scriplet Tag --%>
	<%-- Used to define logic --%>
	<%
	Date date = new Date();
	concat = greet + " " + name;
	%>
	<%-- Expression Tag --%>
	<%-- Used to display --%>
	<%=concat%><br>
	<br>
	<b>Today's date with time is:</b>
	<i><%=date%></i><br><br>
	<%@include file="DateFile.jsp" %>
</body>
</html>