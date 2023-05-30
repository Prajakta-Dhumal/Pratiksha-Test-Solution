<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% double finalBill=(double)request.getAttribute("finalbill"); %>
<h1>FINAL AMOUNT  <%=finalBill %></h1>
</body>
</html>