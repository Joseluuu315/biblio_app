package com.joseluu.biblio_app.controller;

import com.joseluu.biblio_app.service.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar libros vía API.
 */
@RestController
@RequestMapping("/api/libros")
@Tag(
        name = "Libros",
        description = "Operaciones REST sobre libros"
)
public class LibroRestController {

    private final LibroService libroService;

    public LibroRestController(LibroService libroService) {
        this.libroService = libroService;
    }

    @Operation(
            summary = "Eliminar libro",
            description = "Elimina un libro del sistema a partir de su identificador"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Libro eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }
}
