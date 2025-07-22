package com.ipartek.formacion.ejemplobibliotecas.filtros;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/fc/admin/*")
public class AdminFilter extends HttpFilter {

	private static final long serialVersionUID = 4965706796847728485L;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var usuario = request.getSession().getAttribute("usuario");
		
		if(usuario == null) {
			response.sendRedirect(request.getContextPath() + "/fc/login");
			return;
		}
		
		super.doFilter(request, response, chain);
	}

}
