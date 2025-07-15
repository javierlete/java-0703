package com.ipartek.formacion.ejemploweb.listeners;

import java.util.ArrayList;

import com.ipartek.formacion.ejemploweb.modelos.Producto;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SesionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setAttribute("carrito", new ArrayList<Producto>());
	}

}
