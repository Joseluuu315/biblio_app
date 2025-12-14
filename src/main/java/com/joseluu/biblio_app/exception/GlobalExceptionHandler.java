package com.joseluu.biblio_app.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Manejador global de excepciones para la aplicación.
 *
 * <p>
 * Permite centralizar la gestión de errores en la capa MVC, evitando la
 * repetición de bloques try/catch en los controladores.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V6</b> – Gestión de errores centralizada en MVC mediante @ControllerAdvice.</li>
 * </ul>
 *
 * <p>
 * Actualmente maneja {@link LibroNoEncontradoException}, pero se puede
 * ampliar para capturar {@link SocioNoEncontradoException} y
 * {@link PrestamoNoEncontradoException}.
 * </p>
 *
 * <p>
 * Cada excepción puede mapearse a una vista de error específica y/o
 * mensajes personalizados para el usuario.
 * </p>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja la excepción {@link LibroNoEncontradoException}.
     *
     * <p>
     * V6 - Muestra una vista de error con mensaje descriptivo.
     * </p>
     *
     * @param ex excepción lanzada cuando no se encuentra un libro
     * @return {@link ModelAndView} con la vista "error" y mensaje de la excepción
     */
    @ExceptionHandler(LibroNoEncontradoException.class)
    public ModelAndView handleLibroNotFound(LibroNoEncontradoException ex) {
        ModelAndView mv = new ModelAndView("error"); // plantilla error.html
        mv.addObject("mensaje", ex.getMessage());
        return mv;
    }
}
