<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base pageTitle="Log In" browserTitle="Login">
</t:base>

<section class="content">
<form method="post">
	<label for="username">Username</label>
	<input name="username" id="username" required>
	<label for="password">Password</label>
	<input type="password" name="password" id="password" required>
	<input type="submit" value="Log In">
</form>
</section>
</body>
</html>