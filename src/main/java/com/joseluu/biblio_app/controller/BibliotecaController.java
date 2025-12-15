package com.joseluu.biblio_app.controller;

import com.joseluu.biblio_app.entity.Libro;
import com.joseluu.biblio_app.entity.Prestamo;
import com.joseluu.biblio_app.entity.Socio;
import com.joseluu.biblio_app.service.BibliotecaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar los recursos de la biblioteca.
 */
@RestController
@RequestMapping("/api")
@Tag(
        name = "Biblioteca",
        description = "Gestión de libros, socios y préstamos"
)
public class BibliotecaController {

    private final BibliotecaService service;

    public BibliotecaController(BibliotecaService service) {
        this.service = service;
    }

    // ====================== LIBROS ======================

    @Operation(
            summary = "Listar libros",
            description = "Obtiene la lista completa de libros registrados en la biblioteca"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Listado de libros obtenido correctamente"
    )
    @GetMapping("/libros")
    public List<Libro> getAllLibros() {
        return service.getAllLibros();
    }

    @Operation(
            summary = "Crear libro",
            description = "Crea un nuevo libro en la biblioteca"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Libro creado correctamente"
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/libros")
    public Libro crearLibro(@RequestBody Libro libro) {
        return service.saveLibro(libro);
    }

    // ====================== SOCIOS ======================

    @Operation(
            summary = "Listar socios",
            description = "Obtiene la lista completa de socios registrados"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Listado de socios obtenido correctamente"
    )
    @GetMapping("/socios")
    public List<Socio> getAllSocios() {
        return service.getAllSocios();
    }

    @Operation(
            summary = "Crear socio",
            description = "Crea un nuevo socio en el sistema"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Socio creado correctamente"
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/socios")
    public Socio crearSocio(@RequestBody Socio socio) {
        return service.saveSocio(socio);
    }

    // ====================== PRÉSTAMOS ======================

    @Operation(
            summary = "Listar préstamos",
            description = "Obtiene la lista de todos los préstamos registrados"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Listado de préstamos obtenido correctamente"
    )
    @GetMapping("/prestamos")
    public List<Prestamo> getAllPrestamos() {
        return service.getAllPrestamos();
    }

    @Operation(
            summary = "Crear préstamo",
            description = "Registra un nuevo préstamo en la biblioteca"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Préstamo creado correctamente"
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/prestamos")
    public Prestamo crearPrestamo(@RequestBody Prestamo prestamo) {
        return service.savePrestamo(prestamo);
    }
}
