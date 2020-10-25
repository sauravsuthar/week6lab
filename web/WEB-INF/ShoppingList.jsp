<%-- 
    Document   : ShoppingList
    Created on : Oct 24, 2020, 11:40:30 AM
    Author     : 811343
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Shopping List</title>
	</head>
	<body>
		<h1>Shopping List</h1>
		<h2>Welcome, <c:out value="${username}" /></h2>
		<form action="?action=add" method="POST">
			<label for="item">Add item</label>
			<input id="item" name="item">
			<input type="submit" value="Add Item">
		</form>
		<form action="?action=delete" method="POST">
			<c:forEach var = "item" items="${list}" varStatus="stat">
				<input type="radio" value="<c:out value='${stat.count-1}' />" name="deleteIndex" id="item-<c:out value='${stat.count}' />">
				<label for="item-<c:out value='${stat.count}' />"><c:out value='${item}' /></label>
				<br>
			</c:forEach>
			<input type="submit" value="Delete">
		</form>
		<p><a href="?action=logout">Logout</a></p>
	</body>
</html>
