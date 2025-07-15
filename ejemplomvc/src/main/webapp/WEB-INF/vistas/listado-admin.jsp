<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-hover table-striped table-bordered">
	<thead class="table-dark">
		<tr>
			<th class="text-end">Id</th>
			<th>Nombre</th>
			<th class="text-end">Precio</th>
			<th>Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productos}" var="p">
			<tr>
				<th class="text-end">${p.id}</th>
				<td>${p.nombre}</td>
				<td class="text-end"><fmt:formatNumber type="currency" value="${p.precio}"/></td>
				<td>
					<a class="btn btn-primary btn-sm" href="admin/formulario?id=${p.id}"><i class="bi bi-pencil-fill"></i></a>
					<a class="btn btn-danger btn-sm" href="admin/borrar?id=${p.id}"><i class="bi bi-trash-fill"></i></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td colspan="3"></td>
			<td>
				<a class="btn btn-primary btn-sm" href="admin/formulario"><i class="bi bi-plus-lg"></i></a>
			</td>
		</tr>
	</tfoot>
</table>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
