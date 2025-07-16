<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/formulario" method="post" class="needs-validation" novalidate>
	<input type="hidden" name="id" value="${producto.id}">

	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input required type="text" class="form-control ${ producto.errores.nombre != null ? 'is-invalid': '' }" id="nombre" name="nombre"
				value="${fn:escapeXml(producto.nombre)}">
			<div class="invalid-feedback">El nombre es obligatorio</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="precio" class="col-sm-2 col-form-label">Precio</label>
		<div class="col-sm-10">
			<input required min="0" type="number" step=".01" class="form-control ${ producto.errores.precio != null ? 'is-invalid': '' }" id="precio"
				name="precio" value="${producto.precio}">
			<div class="invalid-feedback">El precio debe ser un número positivo</div>
		</div>
	</div>
	<div class="row mb-3">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Guardar</button>
		</div>
	</div>
</form>

<script>
//Example starter JavaScript for disabling form submissions if there are invalid fields
(() => {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})()
</script>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
