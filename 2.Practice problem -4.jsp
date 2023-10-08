<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP Action Tags</h1>
    
 
   <h1>JSP Action Tags</h1>
    
    <%-- Include Action --%>
    <jsp:include page="included.jsp" />
    
    <%-- Forward Action --%>
    <jsp:forward page="forwarded.jsp" />
    
    <%-- Param Action --%>
    <jsp:param name="name" value="sri" />
    <jsp:param name="age" value="30" />
    <jsp:include page="paramExample.jsp" />
    
</body>
</html>