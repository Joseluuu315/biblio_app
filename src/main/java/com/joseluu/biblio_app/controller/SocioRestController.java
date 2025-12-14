package com.joseluu.biblio_app.controller;

import com.joseluu.biblio_app.service.SocioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para manejar operaciones sobre socios vía API.
 *
 * <p>
 * Expone endpoints REST para realizar operaciones CRUD sobre la entidad {@link com.joseluu.biblio_app.entity.Socio}.
 * En esta versión, solo se implementa la eliminación de socios.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V5</b> – Exposición de la entidad Socio mediante API REST.</li>
 *   <li><b>V6</b> – Manejo de errores y códigos HTTP mediante ResponseEntity.</li>
 * </ul>
 *
 * <p>
 * Se mapea a "/api/socios" y delega la lógica de negocio al {@link SocioService}.
 * </p>
 */
@RestController
@RequestMapping("/api/socios")
public class SocioRestController {

    private final SocioService socioservice;

    /**
     * Constructor que inyecta el servicio de socios.
     *
     * @param socioservice servicio para manejar operaciones de socios
     */
    public SocioRestController(SocioService socioservice) {
        this.socioservice = socioservice;
    }

    /**
     * Elimina un socio por su ID.
     *
     * <p>
     * V5 – Endpoint REST para eliminar un socio.
     * V6 – Devuelve un ResponseEntity con código HTTP 200 si la operación es exitosa.
     * </p>
     *
     * @param id id del socio a eliminar
     * @return ResponseEntity con mensaje de éxito
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarSocio(@PathVariable Long id) {
        socioservice.eliminarSocio(id);
        return ResponseEntity.ok("Socio eliminado");
    }
}
