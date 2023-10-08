<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
    
 <h1>Logout</h1>
    
    <%-- Get the session and invalidate it --%>
    <%
        HttpSession session = request.getSession(false); // 
        if (session != null) {
            session.invalidate();
        }
    %>
    
    <p>You have been logged out.</p>
    <p><a href="index.jsp">Return to Home</a></p>
  
</body>
</html>
</body>
</html>