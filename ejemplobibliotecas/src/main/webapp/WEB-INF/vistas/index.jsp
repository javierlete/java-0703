<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

	<h1>${usuario.nombre}</h1>

	<ul>
		<c:forEach items="${productos}" var="p">
			<li>${p.nombre}:${p.precio}</li>
		</c:forEach>
	</ul>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>