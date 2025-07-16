'use strict';

const URL = 'http://localhost:8080/ejemplomvc/api/productos/';
let ul;

window.addEventListener('DOMContentLoaded', async () => {
	ul = document.querySelector('ul');

	rellenarProductos();

	document.forms[0].addEventListener('submit', insertarProducto);
});

async function insertarProducto(evento) {
	evento.preventDefault();

	const form = document.forms[0];

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

	ul.innerHTML = '';
	
	productos.forEach(rellenarProducto);
}

function rellenarProducto(producto) {
	const li = document.createElement('li');

	li.innerHTML = `Nombre: ${producto.nombre}, Precio: ${producto.precio}`;

	ul.appendChild(li);
}
