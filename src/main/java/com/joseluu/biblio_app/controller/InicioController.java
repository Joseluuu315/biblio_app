package com.joseluu.biblio_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador MVC para la página de inicio de la aplicación.
 *
 * <p>
 * Redirige la ruta raíz "/" a la vista principal "menu".
 * Sirve contenido HTML utilizando Spring MVC.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V1</b> – Base mínima de la aplicación con página de inicio.</li>
 *   <li><b>V7</b> – Se podría reutilizar esta vista para incluir menús o estadísticas.</li>
 * </ul>
 */
@Controller
public class InicioController {

    /**
     * Muestra la página de inicio.
     *
     * <p>
     * V1 – Página inicial básica del sistema.
     * </p>
     *
     * @return nombre de la vista "menu" que se renderizará
     */
    @GetMapping("/")
    public String inicio() {
        return "menu";
    }
}
