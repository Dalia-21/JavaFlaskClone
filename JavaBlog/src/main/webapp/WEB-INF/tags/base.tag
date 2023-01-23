<%@tag description="Base Template" pageEncoding="UTF-8"%>
<%@attribute name="pageTitle" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>${pageTitle} - JavaBlog</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css" type="text/css">
</head>
<nav>
	<h1>JavaBlog</h1>
	<ul>
		<li><a href="/Register">Register</a>
		<li><a href="/Login">Login</a>
	</ul>
</nav>
