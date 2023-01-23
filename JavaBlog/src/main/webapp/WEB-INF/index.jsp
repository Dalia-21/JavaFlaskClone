<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="dalia.javablog.models.Post" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base pageTitle="Posts">
</t:base>
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
	<hr>
<%}%>
</body>
</html>
