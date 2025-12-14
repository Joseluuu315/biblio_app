package com.joseluu.biblio_app.controller;

import com.joseluu.biblio_app.entity.Libro;
import com.joseluu.biblio_app.entity.Prestamo;
import com.joseluu.biblio_app.entity.Socio;
import com.joseluu.biblio_app.service.LibroService;
import com.joseluu.biblio_app.service.PrestamoService;
import com.joseluu.biblio_app.service.SocioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador MVC para gestionar préstamos de libros.
 *
 * <p>
 * Permite listar, crear y eliminar préstamos mediante vistas HTML usando Thymeleaf.
 * Interactúa con {@link PrestamoService}, {@link LibroService} y {@link SocioService}.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V1</b> – Alta básica de préstamo, listado y baja sin lógica de penalización ni días.</li>
 *   <li><b>V3</b> – Se puede extender para aplicar reglas de negocio (máximo 3 préstamos, fechas, penalizaciones).</li>
 *   <li><b>V4</b> – Integración con MVC para formularios y vistas HTML.</li>
 * </ul>
 *
 * <p>
 * Se mapea a "/prestamos" y maneja formularios y redirecciones.
 * </p>
 */
@Controller
@RequestMapping("/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;
    private final LibroService libroService;
    private final SocioService socioService;

    /**
     * Constructor que inyecta los servicios necesarios.
     *
     * @param prestamoService servicio de préstamos
     * @param libroService    servicio de libros
     * @param socioService    servicio de socios
     */
    public PrestamoController(
            PrestamoService prestamoService,
            LibroService libroService,
            SocioService socioService) {
        this.prestamoService = prestamoService;
        this.libroService = libroService;
        this.socioService = socioService;
    }

    /**
     * Muestra la lista de todos los préstamos.
     *
     * <p>
     * V1 – Listado de préstamos.
     * </p>
     *
     * @param model objeto Model para pasar datos a la vista
     * @return vista "prestamos" con la lista de préstamos
     */
    @GetMapping
    public String listarPrestamos(Model model) {
        List<Prestamo> prestamos = prestamoService.listarPrestamos();
        model.addAttribute("prestamos", prestamos);
        return "prestamos";
    }

    /**
     * Muestra el formulario para crear un nuevo préstamo.
     *
     * <p>
     * V1 – Formulario para dar de alta un préstamo.
     * </p>
     *
     * @param model objeto Model para pasar datos a la vista
     * @return vista "nuevoPrestamo" con libros y socios disponibles
     */
    @GetMapping("/nuevo")
    public String mostrarFormularioPrestamo(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        model.addAttribute("libros", libroService.listarLibros());
        model.addAttribute("socios", socioService.listarSocios());
        return "nuevoPrestamo";
    }

    /**
     * Guarda un préstamo nuevo, asignando libro y socio reales.
     *
     * <p>
     * V1 – Guardado básico de préstamo con estado ACTIVO.
     * V3 – Podría integrarse para aplicar reglas de negocio (fechas, máximo préstamos, penalizaciones).
     * </p>
     *
     * @param prestamo objeto Prestamo enviado desde el formulario
     * @return redirección a "/prestamos"
     */
    @PostMapping("/guardar")
    public String guardarPrestamo(@ModelAttribute Prestamo prestamo) {
        Libro libro = libroService.obtenerLibroPorId(prestamo.getLibro().getId());
        Socio socio = socioService.obtenerSocioPorId(prestamo.getSocio().getId());
        prestamo.setLibro(libro);
        prestamo.setSocio(socio);
        prestamo.setEstado(Prestamo.Estado.ACTIVO);
        prestamoService.guardarPrestamo(prestamo);
        return "redirect:/prestamos";
    }

    /**
     * Elimina un préstamo existente.
     *
     * <p>
     * V1 – Eliminación de préstamos sin afectar libros o socios.
     * </p>
     *
     * @param id id del préstamo a eliminar
     * @return redirección a "/prestamos"
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarPrestamo(@PathVariable Long id) {
        prestamoService.eliminarPrestamo(id);
        return "redirect:/prestamos";
    }
}
