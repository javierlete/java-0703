<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h1>CARRITO</h1>

<ul>
	<c:forEach items="${carrito}" var="producto">
		<li><a href="detalle?id=${producto.id}">${producto.nombre}</a>: ${producto.precio}</li>
	</c:forEach>
</ul>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
