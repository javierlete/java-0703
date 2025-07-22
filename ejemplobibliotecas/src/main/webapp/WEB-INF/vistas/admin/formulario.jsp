<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form method="post">
	<input type="hidden" name="id" value="${producto.id}" />
	<jl:label-input id="nombre" etiqueta="Nombre"
		valor="${producto.nombre}" error="${errores.nombre}" />
	<jl:label-input id="precio" etiqueta="Precio"
		valor="${producto.precio}" error="${errores.precio}" />
	<jl:label-input tipo="button" etiqueta="Guardar" />
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
