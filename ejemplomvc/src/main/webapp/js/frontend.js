'use strict';

const URL = 'http://localhost:8080/ejemplomvc/api/productos/';
let listado;

window.addEventListener('DOMContentLoaded', async () => {
	listado = document.querySelector('#listado');

	rellenarProductos();

	document.forms[0].addEventListener('submit', insertarProducto);
});

async function insertarProducto(evento) {
	evento.preventDefault();
	evento.stopPropagation();

	const form = document.forms[0];

	if (!form.checkValidity()) {
		form.classList.add('was-validated');
		return;
	}

	const producto = { nombre: form.nombre.value, precio: +form.precio.value };

	await fetch(URL, {
		method: 'POST',
		body: JSON.stringify(producto),
		headers: {
			"Content-Type": "application/json"
		}
	});

	rellenarProductos();
}

async function rellenarProductos() {
	const respuesta = await fetch(URL);
	const productos = await respuesta.json();

	listado.innerHTML = '';

	productos.forEach(rellenarProducto);
}

function rellenarProducto(producto) {
	const div = document.createElement('div');

	div.className = 'col';

	div.innerHTML = `
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
				<small class="text-body-secondary">${producto.precio}</small>
			</div>
		</div>
	`;

	listado.appendChild(div);
}
