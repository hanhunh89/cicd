<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
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
    <h1>Post Detail Page</h1>
    <div>
    	<span>post id : ${post.postId}</span><span>  </span> <span>title : ${post.title}</span>
    </div>
    <div>
    	<span>writer : ${post.writer}</span><span>  </span><span>view : ${post.view}</span>
    </div>
    <div>
    	<c:choose>
			<c:when test="${post.getImageName()==null}">
	 			<img src="<c:url value="/resources/images/default.jpg"/>" style="width:60%"/>
			</c:when>
			<c:otherwise>

<!--  				<img src="<c:url value="/resources/images/${post.getImageName()}"/>" style="width:60%"/>-->
  				<img src="<c:url value="http://storage.googleapis.com/miniboard_attach/${post.getImageName()}"/>" style="width:60%"/>

			</c:otherwise>
		</c:choose>
    </div>
    <div>
    	<p>content</p>
    	<p>${post.content}</p>
    </div>
    <div>
		<span><a href="${deleteURI}">글 삭제</a></span>
	</div>
	<div>
		<span><a href="${goBackURI}">돌아가기</a></span>
	</div>
</body>
</html>