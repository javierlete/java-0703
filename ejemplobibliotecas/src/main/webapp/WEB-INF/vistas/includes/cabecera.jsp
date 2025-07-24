<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="jl"%>
<fmt:setLocale value="es-ES" />
<!DOCTYPE html>
<html lang="es" class="h-100">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ejemplo Bibliotecas</title>
<base href="${pageContext.request.contextPath}/">

<link rel="icon" href="iconos/cart3.svg">

<link rel="stylesheet" href="css/bootstrap-icons.min.css">

<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.bundle.min.js"></script>

</head>
<body class="h-100 d-flex flex-column">

	<nav class="navbar navbar-expand-sm bg-dark" data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="fc/">Ejemplo Bibliotecas</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-sm-0">
					<li class="nav-item"><a class="nav-link" href="fc/">Listado</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false">Categorías</a>
						<ul class="dropdown-menu">
							<c:forEach items="${categorias}" var="c">
								<li><a class="dropdown-item" href="fc/categoria?id=${c.id}">${c.nombre}</a></li>
							</c:forEach>
						</ul></li>
				</ul>

				<ul class="navbar-nav mb-2 mb-sm-0">
					<c:choose>
						<c:when test="${sessionScope.usuario == null}">
							<li class="nav-item"><a class="nav-link" href="fc/login">Login</a></li>
						</c:when>

						<c:otherwise>
							<li class="nav-item"><a class="nav-link"
								href="fc/admin/listado">Listado</a></li>
							<li class="nav-item"><a class="nav-link"
								href="fc/admin/formulario">Formulario</a></li>
							<li class="navbar-text">${sessionScope.usuario.nombre}</li>
							<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>

	<%="<main class='container flex-grow-1 my-5'>"%>