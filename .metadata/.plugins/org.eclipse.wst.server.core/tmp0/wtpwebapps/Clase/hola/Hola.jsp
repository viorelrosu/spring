<%@page import= "helpers.Helpers" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@page errorPage="error.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%-- este metodo calcula el doble de un número --%>
<%-- https://pablomonteserin.com/curso/jsp-jstl/jstl-java-server-page-standard-tag-library/ --%>
<%! 

public int doble(int x) throws Exception {
	
	
	/* if(x==0) {
		throw new Exception("no me gusta el zero.");
	} */
	
	
	return 2*x;
} 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hola</title>
</head>
<body>
	<%@include file="header.html" %>
	<h1>Hola</h1>
	<%
		for(int i=0; i<=5; i++) {
			out.println("<h"+i+">Hola" + doble(i)+"</h"+i+">");
		}
	%>
	<p>
		El doble de 1637 es <%= doble(1637) %>
	</p>
	<%
	
		Map<String,String> m = new HashMap<String,String>();
		m.put("r","Rojo");
		m.put("g","Verde");
		m.put("b","Azul");
		response.getWriter().println("Chechboxes");
	
	%>
	
	<%= Helpers.generaCheckbox("c", m, "r") %>
	
</body>
</html>