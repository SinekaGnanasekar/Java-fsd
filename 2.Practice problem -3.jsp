<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP Directives</h1>
    
    <%-- Page Directive --%>
    <%@ page import="java.util.Date" %>
    <p>Current Date: <%= new Date() %></p>
   
    <c:set var="message" value="Hello from JSTL!" />
    <p>JSTL Message: ${message}</p>
</body>
</html>