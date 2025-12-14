package com.joseluu.biblio_app.service;

import com.joseluu.biblio_app.entity.Libro;
import com.joseluu.biblio_app.exception.LibroNoEncontradoException;
import com.joseluu.biblio_app.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la gestión de la lógica de negocio de los libros.
 *
 * <p>
 * Centraliza las operaciones CRUD sobre la entidad {@link Libro}, actuando
 * como intermediario entre los controladores y la capa de persistencia.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V1</b> – Acceso básico a datos y repositorios JPA.</li>
 *   <li><b>V4</b> – CRUD completo de libros.</li>
 *   <li><b>V6</b> – Gestión de errores mediante excepciones personalizadas.</li>
 * </ul>
 *
 * <p>
 * Lanza {@link LibroNoEncontradoException} cuando se intenta acceder o eliminar
 * un libro inexistente.
 * </p>
 *
 * Se marca con {@link Service} para permitir la inyección automática por parte
 * de Spring.
 */
@Service
public class LibroService {

    /**
     * Repositorio JPA para la entidad {@link Libro}.
     *
     * V1 - Persistencia básica con Spring Data JPA.
     */
    private final LibroRepository libroRepository;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param libroRepository repositorio de libros
     */
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    /**
     * Obtiene el listado completo de libros disponibles en el sistema.
     *
     * <p>
     * V4 - Listado de libros dentro del CRUD completo.
     * </p>
     *
     * @return lista de libros
     */
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    /**
     * Obtiene un libro a partir de su identificador.
     *
     * <p>
     * V4 - Consulta individual de libros.
     * </p>
     * <p>
     * V6 - Control de errores mediante excepción personalizada.
     * </p>
     *
     * @param id identificador del libro
     * @return libro encontrado
     * @throws LibroNoEncontradoException si no existe un libro con ese id
     */
    public Libro obtenerLibroPorId(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() ->
                        new LibroNoEncontradoException("Libro con id " + id + " no encontrado"));
    }

    /**
     * Guarda o actualiza un libro en la base de datos.
     *
     * <p>
     * Permite tanto el alta de un nuevo libro como la modificación
     * de uno existente.
     * </p>
     *
     * <p>
     * V4 - Alta y modificación de libros.
     * </p>
     *
     * @param libro libro a guardar
     * @return libro persistido
     */
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    /**
     * Elimina un libro del sistema a partir de su identificador.
     *
     * <p>
     * Antes de eliminar, se comprueba la existencia del libro,
     * lanzando una excepción si no se encuentra.
     * </p>
     *
     * <p>
     * V4 - Baja de libros.
     * </p>
     * <p>
     * V6 - Gestión de errores si el libro no existe.
     * </p>
     *
     * @param id identificador del libro a eliminar
     * @throws LibroNoEncontradoException si el libro no existe
     */
    public void eliminarLibro(Long id) {
        // V6 - Validación de existencia previa
        Libro libro = obtenerLibroPorId(id);
        libroRepository.delete(libro);
    }
}
