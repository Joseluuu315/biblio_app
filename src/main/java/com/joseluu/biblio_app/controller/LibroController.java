package com.joseluu.biblio_app.controller;

import com.joseluu.biblio_app.entity.Libro;
import com.joseluu.biblio_app.service.LibroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador MVC para gestionar libros de la biblioteca.
 *
 * <p>
 * Permite listar, crear, editar y eliminar libros utilizando vistas HTML.
 * Se integra con {@link LibroService} para la lógica de negocio.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V1</b> – Servicio básico y repositorio de libros.</li>
 *   <li><b>V4</b> – CRUD completo de libros en MVC.</li>
 *   <li><b>V6</b> – Posible mejora futura: validación de campos y manejo de errores en vistas.</li>
 * </ul>
 */
@Controller
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    /**
     * Constructor que inyecta el servicio de libros.
     *
     * @param libroService servicio para manejar libros
     */
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    /**
     * Muestra la lista de todos los libros.
     *
     * @param model objeto Model para pasar datos a la vista
     * @return vista "libros" con la lista de libros
     */
    @GetMapping
    public String listarLibros(Model model) {
        List<Libro> libros = libroService.listarLibros();
        model.addAttribute("libros", libros);
        return "libros";
    }

    /**
     * Muestra el formulario para crear un nuevo libro.
     *
     * @param model objeto Model para pasar datos a la vista
     * @return vista "nuevoLibro" con un objeto Libro vacío
     */
    @GetMapping("/nuevo")
    public String mostrarFormularioLibro(Model model) {
        model.addAttribute("libro", new Libro());
        return "nuevoLibro";
    }

    /**
     * Guarda un libro nuevo o actualizado.
     *
     * <p>
     * V4 – Operación de alta/modificación de libro en MVC.
     * </p>
     *
     * @param libro objeto Libro enviado desde el formulario
     * @return redirección a "/libros"
     */
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro) {
        libroService.guardarLibro(libro);
        return "redirect:/libros";
    }

    /**
     * Muestra el formulario para editar un libro existente.
     *
     * @param id    id del libro a editar
     * @param model objeto Model para pasar datos a la vista
     * @return vista "editarLibro" con los datos del libro correspondiente
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Libro libro = libroService.obtenerLibroPorId(id);
        model.addAttribute("libro", libro);
        return "editarLibro";
    }

    /**
     * Elimina un libro existente.
     *
     * <p>
     * V4 – Operación de baja de libro en MVC.
     * </p>
     *
     * @param id id del libro a eliminar
     * @return redirección a "/libros"
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return "redirect:/libros";
    }
}
