<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Libros</title>
</head>
<body>
	<h2>Lista de Libros</h2>
	<table border="1">
		<tr>
			<th>Isbn</th>
			<th>Título</th>
			<th>Categoría</th>
		</tr>

		<c:forEach var="libro" items="${libros}">
			<tr>
				<td>${libro.isbn}</td>
				<td>${libro.titulo}</td>
				<td>${libro.categoria}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>