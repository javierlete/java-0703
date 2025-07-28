package com.ipartek.formacion.ejemplospring.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ejemplospring.dtos.ProductoDTO;
import com.ipartek.formacion.ejemplospring.entidades.Categoria;
import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.entidades.Usuario;
import com.ipartek.formacion.ejemplospring.repositorios.CategoriaRepository;
import com.ipartek.formacion.ejemplospring.repositorios.ProductoRepository;
import com.ipartek.formacion.ejemplospring.repositorios.UsuarioRepository;

@Service
@Primary
public class AnonimoServiceImpl implements AnonimoService {

	@Autowired
	protected ProductoRepository productoRepository;

	@Autowired
	protected CategoriaRepository categoriaRepository;
	
	@Autowired
	protected UsuarioRepository usuarioRepository;
	
	@Override
	public Iterable<Producto> obtenerListadoProductos() {
		return productoRepository.findAll();
	}

	@Override
	public Optional<Producto> obtenerDetalleProducto(Long id) {
		return productoRepository.findById(id);
	}

	@Override
	public Iterable<ProductoDTO> buscarProductosPorCategoria(Long idCategoria) {
		return productoRepository.findByCategoriaId(idCategoria);
	}

	@Override
	public Iterable<Categoria> obtenerListadoCategorias() {
		return categoriaRepository.findAll();
	}

	@Override
	public Optional<Categoria> obtenerDetalleCategoria(Long id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public Optional<Usuario> autenticar(Usuario usuario) {
		var usuarioEmail = usuarioRepository.findByEmail(usuario.getEmail());
		
		if(usuarioEmail.isEmpty()) {
			return Optional.empty();
		}
		
		if(!usuarioEmail.get().getPassword().equals(usuario.getPassword())) {
			return Optional.empty();
		}
		
		return usuarioEmail;
	}
	
}
