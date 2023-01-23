<%@tag description="Base Template" pageEncoding="UTF-8"%>
<%@attribute name="browserTitle" %>
<%@attribute name="pageTitle" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>${browserTitle} - JavaBlog</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css" type="text/css">
</head>
<body>
<nav>
	<h1>${pageTitle}</h1>
	<ul>
		<li><a href="${pageContext.request.contextPath}/register">Register</a>
		<li><a href="${pageContext.request.contextPath}/login">Login</a>
	</ul>
</nav>
