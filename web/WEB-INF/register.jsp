<%-- 
    Document   : register
    Created on : Oct 24, 2020, 11:22:37 AM
    Author     : 811343
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Register</title>
	</head>
	<body>
		<h1>Register</h1>
		<form action="?action=register" method="POST">
			<label for="name">Name</label>
			<input id="name" name="name">
			<input type="submit" value="Register">
		</form>
	</body>
</html>
