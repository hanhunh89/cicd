<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.springmvc.util.GetServerIp" %>


<header>
    <h1>Server : ${serverIp}</h1>
        <p><%= GetServerIp.getServerIpAddress() %></p>
    
</header>