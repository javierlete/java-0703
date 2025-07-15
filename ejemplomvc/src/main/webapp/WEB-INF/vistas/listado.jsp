<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<ul>
	<c:forEach items="${productos}" var="producto">
		<li><a href="detalle?id=${producto.id}">${producto.nombre}</a>:
			<fmt:formatNumber type="currency" value="${producto.precio}"/>
		</li>
	</c:forEach>
</ul>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
