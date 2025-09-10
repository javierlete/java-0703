'use strict';

let ul, iframe;
let tituloElemento, descripcionElemento, usuarioElemento, comentariosElemento, mostrarMasComentarios;

const URL = '/api/videos';

window.addEventListener('DOMContentLoaded', () => {
	ul = document.querySelector('ul');
	iframe = document.querySelector('iframe');

	tituloElemento = document.getElementById('titulo');
	descripcionElemento = document.getElementById('descripcion');
	usuarioElemento = document.getElementById('usuario');
	comentariosElemento = document.getElementById('comentarios');
	mostrarMasComentarios = document.getElementById('mas-comentarios');

	principal();
});

async function principal(pagina) {
	mostrar('listado');

	const respuesta = await fetch(`${URL}?page=${pagina}`);
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
	const respuesta = await fetch(`${URL}/${id}`);
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
	const respuestaComentarios = await fetch(`${URL}/${id}/comentarios?page=${pagina}&size=1`);
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

function mostrar(id) {
	var sections = document.querySelectorAll('section');
	sections.forEach(section => section.style.display = 'none');

	document.getElementById(id).style.display = null;
}