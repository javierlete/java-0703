<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<fmt:setLocale value="es-ES"/>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Tienda</title>
<base href="${pageContext.request.contextPath}/">
</head>
<body>

	<h1>Tienda</h1>

	<nav>
		<ul>
			<li><a href="listado">Listado</a></li>

			<c:choose>
				<c:when test="${sessionScope.usuario == null}">
					<li><a href="login">Login</a></li>
				</c:when>

				<c:otherwise>
					<li><a href="admin/formulario">Formulario</a></li>
					<li>${sessionScope.usuario.nombre}</li>
					<li><a href="logout">Logout</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>