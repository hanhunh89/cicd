<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="newPost" enctype="multipart/form-data">
		<label>제목</label>
		<form:input path="title"/>
		<label>내용</label>
		<form:input path="content"/>
		<label>이미지</label>
		<form:input path="postImage" type="file" />
		
		<input type="submit" value="등록"/>
	</form:form>
</body>
</html>