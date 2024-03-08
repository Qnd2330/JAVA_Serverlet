<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>jsp Directive - import jsp</title>
</head>
<body>
	<%@page import="java.util.Date"%>
	<h3>
		Today is:
		<%=new Date().toString()%></h3>
</body>
</html>