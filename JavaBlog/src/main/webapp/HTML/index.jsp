<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>JavaBlog Home</title>
</head>
<body>
<%@ page import="dalia.javablog.sqlitedb.Post" %>
<%@ page import="java.util.ArrayList" %>

<%  ArrayList<Post> posts = (ArrayList<Post>)request.getAttribute("posts"); 
for (Post post:posts) {%>
	<p><%= post.getTitle() %>
<%}%>