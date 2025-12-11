package com.joseluu.biblio_app.service;


import com.joseluu.biblio_app.entity.Libro;
import com.joseluu.biblio_app.entity.Prestamo;
import com.joseluu.biblio_app.entity.Socio;
import com.joseluu.biblio_app.repository.LibroRepository;
import com.joseluu.biblio_app.repository.PrestamoRepository;
import com.joseluu.biblio_app.repository.SocioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que gestiona la lógica de negocio de la biblioteca.
 * Proporciona operaciones para libros, socios y préstamos.
 * Utiliza repositorios JPA para acceder a la base de datos.
 * Permite obtener todos los registros y guardar nuevas entidades.
 * Se marca con @Service para la inyección automática de Spring.
 */
@Service
public class BibliotecaService {

    private final LibroRepository libroRepositorio;
    private final SocioRepository socioRepositorio;
    private final PrestamoRepository prestamoRepositorio;

    public BibliotecaService(LibroRepository libroRepositorio, SocioRepository socioRepositorio,
            PrestamoRepository prestamoRepositorio) {
        this.libroRepositorio = libroRepositorio;
        this.socioRepositorio = socioRepositorio;
        this.prestamoRepositorio = prestamoRepositorio;
    }

    // Libros
    public List<Libro> getAllLibros() {
        return libroRepositorio.findAll();
    }

    public Libro saveLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    // Socios
    public List<Socio> getAllSocios() {
        return socioRepositorio.findAll();
    }

    public Socio saveSocio(Socio socio) {
        return socioRepositorio.save(socio);
    }

    // Prestamos
    public List<Prestamo> getAllPrestamos() {
        return prestamoRepositorio.findAll();
    }

    public Prestamo savePrestamo(Prestamo prestamo) {
        return prestamoRepositorio.save(prestamo);
    }

}