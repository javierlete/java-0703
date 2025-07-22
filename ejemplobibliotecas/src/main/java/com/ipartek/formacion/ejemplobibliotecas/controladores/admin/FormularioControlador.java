package com.ipartek.formacion.ejemplobibliotecas.controladores.admin;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import com.ipartek.formacion.bibliotecas.Controlador;
import com.ipartek.formacion.bibliotecas.Errores;
import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AdminNegocio;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.LogicaNegocioException;

public class FormularioControlador implements Controlador {

	@Override
	public String ejecutar(String metodo, Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida) {
		AdminNegocio negocio = (AdminNegocio) Fabrica.obtener("negocio.admin");

		String[] sId = mapaEntrada.get("id");
		Long id = sId == null || sId[0].isBlank() ? null : Long.parseLong(sId[0]);

		if ("GET".equals(metodo)) {
			if (id != null) {
				Optional<Producto> producto = negocio.obtenerDetalleProducto(id);

				if (producto.isPresent()) {
					mapaSalida.put("producto", producto.get());
				}
			}

			return "/admin/formulario";
		}

		String nombre = mapaEntrada.get("nombre")[0];
		String sPrecio = mapaEntrada.get("precio")[0];

		BigDecimal precio = sPrecio.isBlank() ? null: new BigDecimal(sPrecio);

		Producto producto = Producto.builder().id(id).nombre(nombre).precio(precio).build();

		try {
			if (producto.getId() == null) {
				negocio.insertarProducto(producto);
			} else {
				negocio.modificarProducto(producto);
			}
		} catch (LogicaNegocioException e) {
			mapaSalida.put("errores", Errores.contraintViolationsAMapa(e.getErrores()));
			mapaSalida.put("producto", producto);
			
			return "/admin/formulario";
		}

		return "redirect:/admin/listado";
	}

}
