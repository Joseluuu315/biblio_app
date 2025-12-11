package com.joseluu.biblio_app.service;

import com.joseluu.biblio_app.entity.Libro;
import com.joseluu.biblio_app.exception.LibroNoEncontradoException;
import com.joseluu.biblio_app.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que gestiona la lógica de negocio específica de libros.
 * Permite listar, obtener, guardar, actualizar y eliminar libros.
 * Lanza LibroNoEncontradoException si se intenta acceder a un libro
 * inexistente.
 * Utiliza LibroRepository para realizar operaciones de persistencia en la base
 * de datos.
 * Se marca con @Service para la inyección automática en Spring.
 */
@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // Listar todos los libros
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    // Obtener un libro por su ID
    public Libro obtenerLibroPorId(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new LibroNoEncontradoException("Libro con id " + id + " no encontrado"));
    }

    // Guardar o actualizar un libro
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // Eliminar un libro por su ID
    public void eliminarLibro(Long id) {
        Libro libro = obtenerLibroPorId(id); // Lanza excepción si no existe
        libroRepository.delete(libro);
    }
}
