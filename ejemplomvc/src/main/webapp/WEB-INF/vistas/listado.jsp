<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row row-cols-1 row-cols-md-3 g-4">
	<c:forEach items="${productos}" var="producto">
		<div class="col">
			<div class="card h-100">
				<img src="https://picsum.photos/400/300?${producto.id}" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">${producto.nombre}</h5>
					<p class="card-text">This is a wider card with supporting text
						below as a natural lead-in to additional content. This content is
						a little bit longer.</p>
					<div><a href="detalle?id=${producto.id}">Ver detalle</a></div>
				</div>
				<div class="card-footer">
					<small class="text-body-secondary"><fmt:formatNumber
				type="currency" value="${producto.precio}" /></small>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
