<%@ attribute name="imagen" %>
<%@ attribute name="titulo" %>
<%@ attribute name="descripcion" %>
<%@ attribute name="enlace" %>
<%@ attribute name="pie" %>
<div class="col">
	<div class="card h-100">
		<img src="${imagen}"
			class="card-img-top" alt="...">
		<div class="card-body">
			<h5 class="card-title">${titulo}</h5>
			<p class="card-text">${descripcion}</p>
			<div>
				<a href="detalle?id=${enlace}">Ver detalle</a>
			</div>
		</div>
		<div class="card-footer">
			<small class="text-body-secondary">${pie}</small>
		</div>
	</div>
</div>