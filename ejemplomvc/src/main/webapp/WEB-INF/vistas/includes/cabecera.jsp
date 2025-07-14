<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tienda</title>
</head>
<body>

	<h1>Tienda</h1>

	<nav>
		<ul>
			<li><a href="listado">Listado</a></li>
			<li><a href="formulario">Formulario</a></li>

			<c:choose>
				<c:when test="${sessionScope.usuario == null}">
					<li><a href="login">Login</a></li>
				</c:when>

				<c:otherwise>
					<li>${sessionScope.usuario.nombre}</li>
					<li><a href="logout">Logout</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>