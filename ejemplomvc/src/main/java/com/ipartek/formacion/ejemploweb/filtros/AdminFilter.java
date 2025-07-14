package com.ipartek.formacion.ejemploweb.filtros;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/formulario")
public class AdminFilter extends HttpFilter {

	private static final long serialVersionUID = 4965706796847728485L;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var usuario = request.getSession().getAttribute("usuario");
		
		if(usuario == null) {
			response.sendRedirect("login");
			return;
		}
		
		super.doFilter(request, response, chain);
	}

}
