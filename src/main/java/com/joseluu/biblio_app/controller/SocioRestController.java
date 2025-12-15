package com.joseluu.biblio_app.controller;

import com.joseluu.biblio_app.service.SocioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para manejar operaciones sobre socios vía API.
 */
@RestController
@RequestMapping("/api/socios")
@Tag(
        name = "Socios",
        description = "Operaciones REST sobre socios"
)
public class SocioRestController {

    private final SocioService socioService;

    public SocioRestController(SocioService socioService) {
        this.socioService = socioService;
    }

    @Operation(
            summary = "Eliminar socio",
            description = "Elimina un socio del sistema a partir de su identificador"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Socio eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Socio no encontrado")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarSocio(@PathVariable Long id) {
        socioService.eliminarSocio(id);
    }
}
