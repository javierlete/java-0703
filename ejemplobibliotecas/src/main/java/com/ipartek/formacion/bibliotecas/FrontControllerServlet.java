package com.ipartek.formacion.bibliotecas;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;

@Log
@WebServlet("/fc/*")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getPathInfo();

		log.info("URL: " + url);

		Controlador controlador = null;

		try {
			controlador = (Controlador) Fabrica.obtener(url);
		} catch (Exception e) {
			throw new ServletException("No se ha encontrado el controlador para la URL " + url, e);
		}

		String metodo = request.getMethod();

		HttpSession session = request.getSession();

		Map<String, String[]> mapaEntrada = request.getParameterMap();
		Map<String, Object> sesionEntrada = obtenerSesionEntrada(session);

		Map<String, Object> mapaSalida = new HashMap<>();
		Map<String, Object> sesionSalida = new HashMap<>();

		String ruta;

		String rutaPre = controlador.preEjecutar(metodo, mapaEntrada, mapaSalida, sesionEntrada, sesionSalida);

		if (rutaPre != null) {
			ruta = rutaPre;
			irALaSiguienteVista(request, response, session, mapaSalida, sesionSalida, ruta);
			return;
		}

		String rutaEjecutar = controlador.ejecutar(metodo, mapaEntrada, mapaSalida, sesionEntrada, sesionSalida);

		if (rutaEjecutar != null) {
			ruta = rutaEjecutar;
			irALaSiguienteVista(request, response, session, mapaSalida, sesionSalida, ruta);
			return;
		}
	}

	private void irALaSiguienteVista(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Map<String, Object> mapaSalida, Map<String, Object> sesionSalida, String ruta)
			throws IOException, ServletException {
		log.info("RUTA: " + ruta);

		exportarSesionSalida(session, sesionSalida);

		empaquetarModeloParaLaVista(request, mapaSalida);

		saltarALaSiguienteVista(request, response, ruta);
	}

	private Map<String, Object> obtenerSesionEntrada(HttpSession session) {
		Map<String, Object> sesionEntrada = new HashMap<>();
		Enumeration<String> e = session.getAttributeNames();

		while (e.hasMoreElements()) {
			String clave = e.nextElement();

			sesionEntrada.put(clave, session.getAttribute(clave));
		}
		return sesionEntrada;
	}

	private void empaquetarModeloParaLaVista(HttpServletRequest request, Map<String, Object> mapaSalida) {
		for (var par : mapaSalida.entrySet()) {
			request.setAttribute(par.getKey(), par.getValue());
		}
	}

	private void exportarSesionSalida(HttpSession session, Map<String, Object> sesionSalida) {
		for (var par : sesionSalida.entrySet()) {
			session.setAttribute(par.getKey(), par.getValue());
		}
	}

	private void saltarALaSiguienteVista(HttpServletRequest request, HttpServletResponse response, String ruta)
			throws IOException, ServletException {
		if (ruta.startsWith("redirect:")) {
			response.sendRedirect(request.getContextPath() + "/fc" + ruta.replace("redirect:", ""));
		} else {
			request.getRequestDispatcher("/WEB-INF/vistas" + ruta + ".jsp").forward(request, response);
		}
	}

}
