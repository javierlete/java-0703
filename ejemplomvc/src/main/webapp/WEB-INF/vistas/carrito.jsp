<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h1>CARRITO</h1>

<table class="table">
	<thead>
		<tr>
			<th>Nombre</th>
			<th class="text-end">Precio</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${carrito}" var="producto">
			<tr>
				<td>${producto.nombre}</td>
				<td class="text-end"><fmt:formatNumber type="currency" value="${producto.precio}"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
