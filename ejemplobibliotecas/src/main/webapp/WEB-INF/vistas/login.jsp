<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form method="post">
	<jl:label-input tipo="email" id="email" valor="${usuario.email}" etiqueta="Correo electrónico" />
	<jl:label-input tipo="password" id="password" etiqueta="Contraseña" />
	<jl:label-input tipo="button" etiqueta="Inicio de sesión" />
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>