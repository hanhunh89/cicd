<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<body>
		<h1>Login</h1>
		<c:if test="${not empty error}">
			<div class="alert alert-danger">
				<br>UserName과 password가 다르다<br/>
			</div>
		</c:if>	
		<form name="loginform" action="<c:url value="/loginProcess"/>" method="post">
			<input type="text" name="username" placeholder="User Name" required autofocus>
			<input type="password" name="password" placeholder="password" required>
			<button type="submit"> 로그인</button>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			
		</form>		
	</body>
</html>