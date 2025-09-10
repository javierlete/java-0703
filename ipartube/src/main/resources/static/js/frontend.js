'use strict';

let ul, iframe;

const URL = '/api/videos';

window.addEventListener('DOMContentLoaded', () => {
	ul = document.querySelector('ul');
	iframe = document.querySelector('iframe');


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

	iframe.src = video.url;

	mostrar('detalle');
}

function mostrar(id) {
	var sections = document.querySelectorAll('section');
	sections.forEach(section => section.style.display = 'none');

	document.getElementById(id).style.display = null;
}