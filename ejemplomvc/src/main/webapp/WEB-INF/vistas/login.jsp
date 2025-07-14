<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<form action="login" method="post">
	<input name="email" placeholder="Correo electrónico" value="${usuario.email}">
	<input name="password" placeholder="Contraseña">
	
	<button>Iniciar sesión</button>
	
	<div>${mensaje}</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
