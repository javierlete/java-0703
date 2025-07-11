<%@ page import="com.ipartek.formacion.ejemploweb.modelos.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
var productos = (Iterable<Producto>)request.getAttribute("productos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<ul>
<% for(var producto: productos) { %>
	<li><%=producto %></li>
<% } %>
</ul>

</body>
</html>