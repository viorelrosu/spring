<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>Hola JSP</h1>
	<ul>
	<c:forEach var="persona" items="${personas}">
		<li>[${persona.dni}] ${persona.nombre}</li>
	</c:forEach>
	</ul>
	<%--
	
	<c:if test=”${edad>30}”>
   		Eres una persona adulta de ${edad} años
	</c:if>
	
	
	<c:choose> 
  		<c:when test="${condicion1}"> ... </c:when> 
  		<c:when test="${condicion2}"> ... </c:when>
  		<c:otherwise> ... </c:otherwise> 
	</c:choose>
	
	 --%>
	
</body>
</html>