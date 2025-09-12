'use strict';

let ul, iframe, tbody, formularioVideo;
let tituloElemento, descripcionElemento, usuarioElemento, comentariosElemento, mostrarMasComentarios;

// TODO cambiar el ID por un usuario real
const ID_USUARIO = 1;

const URL = '/api';
const URL_VIDEOS = URL + '/videos';
const URL_USUARIOS = URL + '/usuarios';

window.addEventListener('DOMContentLoaded', () => {
	ul = document.querySelector('ul');
	iframe = document.querySelector('iframe');
	tbody = document.querySelector('tbody');
	formularioVideo = document.querySelector('#mantenimiento form');

	tituloElemento = document.getElementById('titulo');
	descripcionElemento = document.getElementById('descripcion');
	usuarioElemento = document.getElementById('usuario');
	comentariosElemento = document.getElementById('comentarios');
	mostrarMasComentarios = document.getElementById('mas-comentarios');

	principal();
});

async function principal(pagina) {
	mostrar('listado');

	const respuesta = await fetch(`${URL_VIDEOS}?page=${pagina}`);
	const objeto = await respuesta.json();

	const videos = objeto.content;

	console.log(videos);

	ul.innerHTML = '';

	videos.forEach(video => {
		const li = document.createElement('li');

		li.innerHTML = `
				<a href="javascript:detalle(${video.id})">${video.titulo}</a>
				(${video.usuario.nombre})
			`;

		ul.appendChild(li);
	});

	delete iframe.src;

	const page = objeto.page;

	console.log(page);

	document.querySelectorAll('.pagina').forEach(pagina => pagina.remove());

	for (let numeroPagina = page.totalPages - 1; numeroPagina >= 0; numeroPagina--) {
		var li = document.createElement('li');
		var a = document.createElement('a');

		li.className = 'pagina';

		li.appendChild(a);


		a.innerText = numeroPagina + 1;

		a.href = '#';

		a.addEventListener('click', e => {
			e.preventDefault();

			principal(numeroPagina);
		});

		document.getElementById('anterior').parentElement.insertAdjacentElement("afterend", li);

	}


	document.getElementById('primero').onclick = e => {
		e.preventDefault();

		principal(0);
	};

	document.getElementById('anterior').onclick = e => {
		e.preventDefault();

		principal(page.number - 1);
	};

	document.getElementById('siguiente').onclick = e => {
		e.preventDefault();

		principal(page.number + 1);
	};

	document.getElementById('ultimo').onclick = e => {
		e.preventDefault();

		principal(page.totalPages - 1);
	};
}

async function detalle(id) {
	const respuesta = await fetch(`${URL_VIDEOS}/${id}`);
	const video = await respuesta.json();

	console.log(video);

	tituloElemento.innerText = video.titulo;
	descripcionElemento.innerText = video.descripcion;
	usuarioElemento.innerText = video.usuario.nombre;

	iframe.src = video.url;

	mostrar('detalle');

	comentariosElemento.innerHTML = '';

	await mostrarComentarios(id);
}

async function mostrarComentarios(id, pagina = 0) {
	const respuestaComentarios = await fetch(`${URL_VIDEOS}/${id}/comentarios?page=${pagina}&size=1`);
	const objeto = await respuestaComentarios.json();

	const page = objeto.page;
	const comentarios = objeto.content;

	console.log(page);
	console.log(comentarios);

	comentarios.forEach(comentario => {
		const dt = document.createElement('dt');
		const dd = document.createElement('dd');

		dt.innerText = `${comentario.usuario} (${comentario.fechaHora})`;
		dd.innerText = comentario.texto;

		comentariosElemento.appendChild(dt);
		comentariosElemento.appendChild(dd);
	});

	mostrarMasComentarios.onclick = e => {
		e.preventDefault();

		mostrarComentarios(id, pagina + 1);
	};
}

async function mantenimiento() {
	mostrar('mantenimiento');

	const respuesta = await fetch(`${URL_USUARIOS}/${ID_USUARIO}/videos`);
	const pagina = await respuesta.json();

	console.log(pagina);

	tbody.innerHTML = '';

	pagina.content.forEach(video => {
		const tr = document.createElement('tr');

		tr.innerHTML = `
			<th>${video.id}</th>
			<td>${video.titulo}</td>
			<td>${video.url}</td>
			<td>
				<a href="javascript:formulario(${video.id})">Editar</a>
				<a href="javascript:borrar(${video.id})">Borrar</a>
			</td>
		`;

		tbody.appendChild(tr);
	});
}

async function formulario(id) {
	if (id) {
		const respuesta = await fetch(`${URL_VIDEOS}/${id}`);
		const video = await respuesta.json();
		
		formularioVideo['id'].value = video.id;
		formularioVideo.titulo.value = video.titulo;
		formularioVideo.url.value = video.url;
		formularioVideo.descripcion.value = video.descripcion;
	}
}

async function borrar(id) {
	await fetch(`${URL_USUARIOS}/${ID_USUARIO}/videos/${id}`, { method: 'DELETE' });

	mantenimiento();
}

function mostrar(id) {
	var sections = document.querySelectorAll('section');
	sections.forEach(section => section.style.display = 'none');

	document.getElementById(id).style.display = null;
}
