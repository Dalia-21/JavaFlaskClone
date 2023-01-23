<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>JavaBlog Home</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/../static/style.css" type="text/css">
</head>
<body>
<%@ page import="dalia.javablog.models.Post" %>
<%@ page import="java.util.ArrayList" %>

<section class="content">
<%  ArrayList<Post> posts = (ArrayList<Post>)request.getAttribute("posts"); 
for (Post post:posts) {%>
	<article class="post">
		<header>
			<div>
				<h1><%= post.getTitle() %></h1>
				<div class="about">by <%= post.getAuthorName() %> on 
					<%= post.getTimestamp() %>
				</div>
			</div>
		</header>
		<p class="body"><%= post.getBody() %></p>
	</article>
<%}%>
</section>