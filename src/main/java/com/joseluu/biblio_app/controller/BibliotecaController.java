package com.joseluu.biblio_app.controller;

import com.joseluu.biblio_app.entity.Libro;
import com.joseluu.biblio_app.entity.Prestamo;
import com.joseluu.biblio_app.entity.Socio;
import com.joseluu.biblio_app.service.BibliotecaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar los recursos de la biblioteca.
 * Proporciona endpoints para Libros, Socios y Prestamos.
 */
@RestController
@RequestMapping("/api")
public class BibliotecaController {

    private final BibliotecaService service;

    /**
     * Constructor del controlador que inyecta el servicio de la biblioteca.
     *
     * @param service servicio que maneja la lógica de negocio de libros, socios y
     *                préstamos
     */
    public BibliotecaController(BibliotecaService service) {
        this.service = service;
    }

    // ====================== LIBROS ======================

    /**
     * Obtiene la lista de todos los libros registrados en la biblioteca.
     *
     * @return lista de libros
     */
    @GetMapping("/libros")
    public List<Libro> getAllLibros() {
        return service.getAllLibros();
    }

    /**
     * Crea un nuevo libro y lo guarda en la biblioteca.
     *
     * @param libro objeto Libro a crear
     * @return el libro creado
     */
    @PostMapping("/libros")
    public Libro crearLibro(@RequestBody Libro libro) {
        return service.saveLibro(libro);
    }

    // ====================== SOCIOS ======================

    /**
     * Obtiene la lista de todos los socios registrados en la biblioteca.
     *
     * @return lista de socios
     */
    @GetMapping("/socios")
    public List<Socio> getAllSocios() {
        return service.getAllSocios();
    }

    /**
     * Crea un nuevo socio y lo guarda en la biblioteca.
     *
     * @param socio objeto Socio a crear
     * @return el socio creado
     */
    @PostMapping("/socios")
    public Socio crearSocio(@RequestBody Socio socio) {
        return service.saveSocio(socio);
    }

    // ====================== PRÉSTAMOS ======================

    /**
     * Obtiene la lista de todos los préstamos registrados en la biblioteca.
     *
     * @return lista de préstamos
     */
    @GetMapping("/prestamos")
    public List<Prestamo> getAllPrestamos() {
        return service.getAllPrestamos();
    }

    /**
     * Crea un nuevo préstamo y lo guarda en la biblioteca.
     *
     * @param prestamo objeto Prestamo a crear
     * @return el préstamo creado
     */
    @PostMapping("/prestamos")
    public Prestamo crearPrestamo(@RequestBody Prestamo prestamo) {
        return service.savePrestamo(prestamo);
    }
}
