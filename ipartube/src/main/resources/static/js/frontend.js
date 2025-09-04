'use strict';

let ul, iframe;

window.addEventListener('DOMContentLoaded', () => {
	ul = document.querySelector('ul');
	iframe = document.querySelector('iframe');

	principal();

	console.log(ul);
	console.log(iframe);
});

async function principal() {
	iframe.style.display = 'none';

	const respuesta = await fetch('/api/videos');
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

	ul.style.display = null;

	delete iframe.src;
}

async function detalle(id) {
	ul.style.display = 'none';

	const respuesta = await fetch('/api/videos/' + id);
	const video = await respuesta.json();

	console.log(video);

	iframe.src = video.url;

	iframe.style.display = null;
}