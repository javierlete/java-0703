package com.ipartek.formacion.ejemploweb.modelos;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import bibliotecas.Identificable;

public class Producto implements Identificable {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	
	private Map<String, String> errores = new HashMap<>();

	public Producto(Producto producto) {
		this(producto.id, producto.nombre, producto.precio);
	}
	
	public Producto(String id, String nombre, String precio) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
	}
	
	public Producto(Long id, String nombre, BigDecimal precio) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
	}

	private void setId(String id) {
		try {
			setId(id.isBlank() ? null : Long.parseLong(id));
		} catch (NumberFormatException e) {
			errores.put("id", "El id no es obligatorio pero debe ser numérico");
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.isBlank()) {
			errores.put("nombre", "El nombre es obligatorio");
		}
		
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	private void setPrecio(String precio) {
		try {
			setPrecio(new BigDecimal(precio));
		} catch (Exception e) {
			errores.put("precio", "El precio debe ser una cantidad numérica");
		}
	}

	public void setPrecio(BigDecimal precio) {
		if(precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
			errores.put("precio", "El precio es obligatorio y debe ser positivo");
		}
		
		this.precio = precio;
	}

	public Map<String, String> getErrores() {
		return errores;
	}

	public boolean hayErrores() {
		return errores.size() > 0;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return String.format("Producto [id=%s, nombre=%s, precio=%s, errores=%s]", id, nombre, precio, errores);
	}

}
