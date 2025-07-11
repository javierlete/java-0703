<%@ page import="bibliotecas.Fabrica"%>
<%@ page import="accesodatos.DaoPersona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
var dao = (DaoPersona) Fabrica.obtener("dao.persona", "dao.url");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado personas</title>
</head>
<body>

	<h1>Personas</h1>
	
	<ul>
	<%
	for (var persona : dao.obtenerTodos()) {
	%>
		<li><%=persona.getNombre()%>, <%=persona.getRol().getNombre()%></li>
	<%
	}
	%>
	</ul>
</body>
</html>