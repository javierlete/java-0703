package com.ipartek.formacion.ejemplospring.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ipartek.formacion.ejemplospring.servicios.AdminService;
import com.ipartek.formacion.ejemplospring.servicios.AnonimoService;

@Component
public class AnonimoServicePrueba implements CommandLineRunner {
	@Autowired
	private AnonimoService anonimoService;
	
	@Autowired
	private AdminService adminService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(anonimoService.obtenerListadoCategorias());
		
		System.out.println(anonimoService.obtenerDetalleCategoria(2L));
		
		System.out.println(adminService.obtenerListadoProductos());
	}
}
