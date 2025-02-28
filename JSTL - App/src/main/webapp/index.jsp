<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="name" value="Vatsal"></c:set>
	My name is
	<b><a></a><c:out value="${name}"></c:out></b><br><br>
	<c:set var="age" value="21"></c:set>
	My age is
	<b><a></a><c:out value="${age}"></c:out></b><br><br>
	
	<c:if test="${age > 18}"><b>Eligible</b></c:if>
</body>
</html>