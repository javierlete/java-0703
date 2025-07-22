<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row row-cols-1 row-cols-md-3 g-4">
	<c:forEach items="${productos}" var="producto">
		<jl:tarjeta imagen="https://picsum.photos/400/300?${producto.id}"
			titulo="${producto.nombre}" descripcion="BLABLABLA"
			enlace="detalle?id=${producto.id}" pie="${producto.precio}" />
	</c:forEach>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>