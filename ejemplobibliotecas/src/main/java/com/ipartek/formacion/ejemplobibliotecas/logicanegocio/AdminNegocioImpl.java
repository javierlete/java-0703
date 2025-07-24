package com.ipartek.formacion.ejemplobibliotecas.logicanegocio;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Categoria;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class AdminNegocioImpl extends AnonimoNegocioImpl implements AdminNegocio {
	private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private static final Validator validator = factory.getValidator();

	@Override
	public Producto insertarProducto(Producto producto) {
		var errores = validator.validate(producto);

		if (errores.isEmpty()) {
			return DAO_PRODUCTO.insertar(producto);
		} else {
			throw new LogicaNegocioException("Producto incorrecto", errores);
		}
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		var errores = validator.validate(producto);

		if (errores.isEmpty()) {
			return DAO_PRODUCTO.modificar(producto);
		} else {
			throw new LogicaNegocioException("Producto incorrecto", errores);
		}
	}

	@Override
	public void borrarProducto(Long id) {
		DAO_PRODUCTO.borrar(id);
	}

	@Override
	public Object insertarCategoria(Categoria categoria) {
		return DAO_CATEGORIA.insertar(categoria);
	}

	@Override
	public Categoria modificarCategoria(Categoria categoria) {
		return DAO_CATEGORIA.modificar(categoria);
	}

	@Override
	public void borrarCategoria(Long id) {
		DAO_CATEGORIA.borrar(id);
	}

}
