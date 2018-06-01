<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Item</title>
</head>
<body>
<h1>Update Item</h1>

<form action="updateitem" method="post">
		ID: ${id } 
		<input type="hidden" name="id" value="${id }">
		Name: <input type="text" name="name"> 
		Description: <input type="text" name="description">
		Quantity: <input type="text" name="quantity">  
		Price: <input type="text" name="price"> 
		<input type="submit" value="Submit">

	</form>

</body>
</html>