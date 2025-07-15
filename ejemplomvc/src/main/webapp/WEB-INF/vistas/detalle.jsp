<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<dl>
	<dt>Nombre</dt>
	<dd>${producto.nombre}</dd>
	<dt>Precio</dt>
	<dd>${producto.precio}</dd>
</dl>

<div>
	<a href="carrito?id=${producto.id}">Añadir al carrito</a>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
