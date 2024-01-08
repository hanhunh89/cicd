<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<%@ include file="header.jsp" %> 
    <h1>version : 3 ! </h1>

<h1>
	Hello world!  
</h1>

<p><a href="${pageContext.request.contextPath}/login">Login</a></p>
<p><a href="${pageContext.request.contextPath}/user/join">Join</a></p>

</body>
</html>
