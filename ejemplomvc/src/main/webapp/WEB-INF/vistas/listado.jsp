<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<ul>
	<c:forEach items="${productos}" var="producto">
		<li>${producto.nombre}: ${producto.precio}</li>
	</c:forEach>
</ul>

</body>
</html>