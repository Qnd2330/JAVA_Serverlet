<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP expression tag</title>
</head>
<body>
	<h1>Truyền dữ liệu giữa 2 trang jsp</h1>
	<%
	application.setAttribute("DEV", "Devmaster Academy");
	%>
	<a href="Bai05.02.jsp">Click here</a>
</body>
</html>