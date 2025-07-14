<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<form action="formulario" method="post">
	<input name="nombre" placeholder="Nombre">
	<input name="precio" placeholder="Precio">
	
	<button>Guardar</button>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
