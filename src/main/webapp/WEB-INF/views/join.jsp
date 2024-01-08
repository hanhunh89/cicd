<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>			
	<h1>Join</h1>
	<c:if test="${not empty userExist}">
		<div>
			<br>이미 존재하는 사용자입니다. 다른 id를 입력해주세요<br/>
		</div>
	</c:if>
	<form:form modelAttribute="newUser" enctype="multipart/form-data" action="${pageContext.request.contextPath}/user/join">
		<label>id</label>
		<form:input path="userId"/>
		<label>password</label>
		<form:input path="password"/>		
		<input type="submit" value="등록"/>
	</form:form>
</body>
</html>