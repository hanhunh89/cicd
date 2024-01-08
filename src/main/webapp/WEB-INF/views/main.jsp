<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main Page ver2</title>
    <style>
    	table {
    		border-spacing: 0;
    		border: 2px solid #888888;
    		margin: 0 auto;
   		}
   		tr, th, td {
    		border: 1px solid #888888;
  		}
    </style>
</head>
<body>
	<%@ include file="header.jsp" %> 
    <h1>Hello  ${user_id} </h1>
	
    <h1>${user_id2}</h1>
	<p><a href="${pageContext.request.contextPath}/logout">Logout</a></p>    
	<p></p>
    <table>
  		<thead>
    		<tr>
    			<th>PostId</th>
      			<th>Title</th>
      			<th>Writer</th>
      			<th>View</th>
    		</tr>
  		</thead>
  		<tbody>
    		<c:forEach items="${postList}" var="post">
      			<tr>
      				<td>${post.postId}</td>
        			<td><a href="${currentURI}/${post.postId}">${post.title}</a></td>
        			<td>${post.writer}</td>
        			<td>${post.view}</td>
      			</tr>
    		</c:forEach>
  		</tbody>
	</table>
	<div>
		<span><a href="${currentURI}/addPost">글쓰기</a></span>
	</div>
	
</body>
</html>