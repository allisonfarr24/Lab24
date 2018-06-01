<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>GC Coffee Shop</title>

</head>
<body>

	<h1>Welcome to GC Coffee Shop!</h1>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list }">
				<tr>
					<td>${item.id }</td>
					<td>${item.name }</td>
					<td>${item.description }</td>
					<td>${item.quantity }</td>
					<td>${item.price }</td>
					<td><a href="delete?id=${item.id }">Delete</a></td>
					<td><a href="update?id=${item.id }">Update</a></td>
					<!-- use anchor tag <a></a> for links -->
					<!-- the href typically refers to and outside link or some place in another page (ex- Request Mapping - delete) -->
				</tr>

			</c:forEach>
		</tbody>
	</table>

	<h2>Search for an Item by ID Here:</h2>
	<form action="search">
		ID: <input type="text" name="id"> 
		<input type="submit" value="Submit">
	</form>

	<h2>Add a New Item Here:</h2>
	<form action="add" method="post">
		Name: <input type="text" name="name"> 
		Description: <input type="text" name="description"> 
		Quantity: <input type="text" name="quantity"> 
		Price: <input type="text" name="price"> 
		<input type="submit" value="Add">

	</form>
</body>
</html>