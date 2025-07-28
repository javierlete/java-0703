package com.ipartek.formacion.ejemplospring.servicios;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.ejemplospring.entidades.Categoria;
import com.ipartek.formacion.ejemplospring.entidades.Producto;

@Service
public class AdminServiceImpl extends AnonimoServiceImpl implements AdminService {

	@Override
	public Producto insertarProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		productoRepository.deleteById(id);
	}

	@Override
	public Categoria insertarCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public Categoria modificarCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public void borrarCategoria(Long id) {
		categoriaRepository.deleteById(id);
	}

}
