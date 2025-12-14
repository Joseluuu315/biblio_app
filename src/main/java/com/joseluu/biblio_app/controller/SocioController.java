package com.joseluu.biblio_app.controller;

import com.joseluu.biblio_app.entity.Socio;
import com.joseluu.biblio_app.service.SocioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador MVC para gestionar socios de la biblioteca.
 *
 * <p>
 * Permite listar, crear, editar y eliminar socios mediante vistas HTML
 * usando Thymeleaf.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V4</b> – CRUD completo de socios en MVC (vistas y formularios).</li>
 *   <li><b>V6</b> – Preparado para validación de formularios y manejo de errores en vistas.</li>
 * </ul>
 *
 * <p>
 * Se mapea a "/socios" y utiliza {@link SocioService} para la lógica de negocio.
 * </p>
 */
@Controller
@RequestMapping("/socios")
public class SocioController {

    private final SocioService socioService;

    /**
     * Constructor que inyecta el servicio de socios.
     *
     * @param socioService servicio para manejar socios
     */
    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    /**
     * Muestra la lista de todos los socios.
     *
     * <p>
     * V4 – Listado de socios en la vista "socios".
     * </p>
     *
     * @param model objeto Model para pasar datos a la vista
     * @return vista "socios" con la lista de socios
     */
    @GetMapping
    public String listarSocios(Model model) {
        model.addAttribute("socios", socioService.listarSocios());
        return "socios";
    }

    /**
     * Muestra el formulario para crear un nuevo socio.
     *
     * <p>
     * V4 – Formulario de creación.
     * </p>
     *
     * @param model objeto Model para pasar datos a la vista
     * @return vista "nuevoSocio" con un objeto Socio vacío
     */
    @GetMapping("/nuevo")
    public String formularioNuevoSocio(Model model) {
        model.addAttribute("socio", new Socio());
        return "nuevoSocio";
    }

    /**
     * Guarda un socio nuevo o editado.
     *
     * <p>
     * V4 – Maneja el POST de creación o edición.
     * </p>
     *
     * @param socio objeto Socio enviado desde el formulario
     * @return redirección a "/socios"
     */
    @PostMapping("/guardar")
    public String guardarSocio(@ModelAttribute Socio socio) {
        socioService.guardarSocio(socio);
        return "redirect:/socios";
    }

    /**
     * Muestra el formulario para editar un socio existente.
     *
     * <p>
     * V4 – Formulario de edición con datos pre-cargados.
     * </p>
     *
     * @param id    id del socio a editar
     * @param model objeto Model para pasar datos a la vista
     * @return vista "nuevoSocio" con los datos del socio correspondiente
     */
    @GetMapping("/editar/{id}")
    public String formularioEditarSocio(@PathVariable Long id, Model model) {
        model.addAttribute("socio", socioService.obtenerSocioPorId(id));
        return "nuevoSocio";
    }

    /**
     * Elimina un socio existente.
     *
     * <p>
     * V4 – Eliminación vía MVC, redirigiendo al listado.
     * </p>
     *
     * @param id id del socio a eliminar
     * @return redirección a "/socios"
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarSocio(@PathVariable Long id) {
        socioService.eliminarSocio(id);
        return "redirect:/socios";
    }
}
