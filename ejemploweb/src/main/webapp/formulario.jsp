<%@ page import="pojos.Rol"%>
<%@ page import="pojos.Persona"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="bibliotecas.Fabrica"%>
<%@ page import="accesodatos.DaoPersona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String nombre = request.getParameter("nombre");
String sFechaNacimiento = request.getParameter("fecha-nacimiento");

Persona insertada = null;

if (nombre != null && sFechaNacimiento != null) {
	LocalDate fechaNacimiento = LocalDate.parse(sFechaNacimiento);

	var rol = new Rol(2L, null, null);

	var persona = new Persona(null, nombre, fechaNacimiento, rol);

	var dao = (DaoPersona) Fabrica.obtener("dao.persona", "dao.url");

	insertada = dao.insertar(persona);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario persona</title>
</head>
<body>

	<form method="post">
		<input name="nombre"> <input name="fecha-nacimiento"
			type="date">

		<button>Guardar</button>
		
		<% if(insertada != null) { %>
			<div>Se ha insertado <%= insertada.getId()%></div>
		<% } %>
	</form>
</body>
</html>