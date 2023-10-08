<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>JSP Implicit Objects Example</h1>
    
    <h2>Request Implicit Object</h2>
    <p>Client IP Address: <%= request.getRemoteAddr() %></p>
    <p>Request URI: <%= request.getRequestURI() %></p>
    
    <h2>Response Implicit Object</h2>
    <p>Response Content Type: <%= response.getContentType() %></p>
    
    <h2>Out Implicit Object</h2>
    <%
        out.println("This is output using the out implicit object.");
    %>
    
    <h2>Session Implicit Object</h2>
    <%
        session.setAttribute("username", "JohnDoe");
        out.println("Username stored in session: " + session.getAttribute("username"));
    %>
    
    <h2>Application Implicit Object</h2>
    <%
        application.setAttribute("appVar", "SampleValue");
        out.println("Application Variable: " + application.getAttribute("appVar"));
    %>

</body>
</html>