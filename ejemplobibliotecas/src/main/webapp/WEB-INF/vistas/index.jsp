<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${usuario.nombre}</h1>

	<ul>
		<c:forEach items="${productos}" var="p">
			<li>${p.nombre}:${p.precio}</li>
		</c:forEach>
	</ul>

</body>
</html>