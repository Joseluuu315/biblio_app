package com.joseluu.biblio_app.controller;

import com.joseluu.biblio_app.service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para gestionar libros vía API.
 *
 * <p>
 * Proporciona endpoints para eliminar libros utilizando solicitudes HTTP DELETE.
 * Se integra con {@link LibroService} para la lógica de negocio.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V1</b> – Repositorio y servicio básico para libros.</li>
 *   <li><b>V4</b> – CRUD completo en MVC (aquí complementado con REST para V5).</li>
 *   <li><b>V5</b> – API REST de libros, probado con Postman o Thunder Client.</li>
 * </ul>
 */
@RestController
@RequestMapping("/api/libros")
public class LibroRestController {

    private final LibroService libroService;

    /**
     * Constructor que inyecta el servicio de libros.
     *
     * @param libroService servicio que maneja la lógica de libros
     */
    public LibroRestController(LibroService libroService) {
        this.libroService = libroService;
    }

    /**
     * Elimina un libro por su ID.
     *
     * <p>
     * V5 – Endpoint REST para borrar un libro usando HTTP DELETE.
     * Devuelve un ResponseEntity con mensaje de éxito.
     * </p>
     *
     * @param id id del libro a eliminar
     * @return ResponseEntity con mensaje de éxito
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.ok("Libro eliminado");
    }
}
