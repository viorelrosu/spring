<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Libro</title>
</head>
<body>
<h2>Nuevo libro</h2>
<form method="post" action="/Ej12jsp">
	ISBN <input type="text" name="isbn" ><br><br>
	Título <input type="text" name="titulo" ><br><br>
	Categoría <input type="text" name="categoria" ><br><br>
	<input type="submit">
</form>
</body>
</html>