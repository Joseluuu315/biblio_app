package com.joseluu.biblio_app.service;

import com.joseluu.biblio_app.entity.Libro;
import com.joseluu.biblio_app.entity.Prestamo;
import com.joseluu.biblio_app.entity.Socio;
import com.joseluu.biblio_app.repository.LibroRepository;
import com.joseluu.biblio_app.repository.PrestamoRepository;
import com.joseluu.biblio_app.repository.SocioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio general de la biblioteca.
 *
 * <p>
 * Proporciona operaciones básicas para la gestión de libros, socios y préstamos,
 * actuando como una capa de servicio inicial y simplificada.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V1</b> – Servicio básico para acceso a datos y operaciones mínimas.</li>
 *   <li><b>V4</b> – Soporte inicial para operaciones CRUD (sin lógica avanzada).</li>
 * </ul>
 *
 * <p>
 * Este servicio es típico de una primera versión del proyecto. En versiones
 * posteriores (V3, V4 avanzadas), su lógica suele migrarse a servicios
 * especializados como {@code LibroService}, {@code SocioService} y
 * {@code PrestamoService}.
 * </p>
 *
 * Se marca con {@link Service} para permitir la inyección automática de
 * dependencias por parte de Spring.
 */
@Service
public class BibliotecaService {

    /**
     * Repositorio JPA para la entidad {@link Libro}.
     *
     * V1 - Acceso básico a datos de libros.
     */
    private final LibroRepository libroRepositorio;

    /**
     * Repositorio JPA para la entidad {@link Socio}.
     *
     * V1 - Acceso básico a datos de socios.
     */
    private final SocioRepository socioRepositorio;

    /**
     * Repositorio JPA para la entidad {@link Prestamo}.
     *
     * V1 - Acceso básico a datos de préstamos.
     */
    private final PrestamoRepository prestamoRepositorio;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param libroRepositorio repositorio de libros
     * @param socioRepositorio repositorio de socios
     * @param prestamoRepositorio repositorio de préstamos
     */
    public BibliotecaService(LibroRepository libroRepositorio,
                             SocioRepository socioRepositorio,
                             PrestamoRepository prestamoRepositorio) {
        this.libroRepositorio = libroRepositorio;
        this.socioRepositorio = socioRepositorio;
        this.prestamoRepositorio = prestamoRepositorio;
    }

    /* =======================
       ========== LIBROS =====
       ======================= */

    /**
     * Obtiene el listado completo de libros.
     *
     * <p>
     * V1 - Listado básico de libros.
     * </p>
     *
     * @return lista de libros
     */
    public List<Libro> getAllLibros() {
        return libroRepositorio.findAll();
    }

    /**
     * Guarda un libro en la base de datos.
     *
     * <p>
     * V1 - Alta básica de libros.
     * </p>
     *
     * @param libro libro a guardar
     * @return libro persistido
     */
    public Libro saveLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    /* =======================
       ========== SOCIOS =====
       ======================= */

    /**
     * Obtiene el listado completo de socios.
     *
     * <p>
     * V1 - Listado básico de socios.
     * </p>
     *
     * @return lista de socios
     */
    public List<Socio> getAllSocios() {
        return socioRepositorio.findAll();
    }

    /**
     * Guarda un socio en la base de datos.
     *
     * <p>
     * V1 - Alta básica de socios.
     * </p>
     *
     * @param socio socio a guardar
     * @return socio persistido
     */
    public Socio saveSocio(Socio socio) {
        return socioRepositorio.save(socio);
    }

    /* =========================
       ========== PRÉSTAMOS ====
       ========================= */

    /**
     * Obtiene el listado completo de préstamos.
     *
     * <p>
     * V1 - Listado básico de préstamos.
     * </p>
     *
     * @return lista de préstamos
     */
    public List<Prestamo> getAllPrestamos() {
        return prestamoRepositorio.findAll();
    }

    /**
     * Guarda un préstamo en la base de datos.
     *
     * <p>
     * V1 - Alta básica de préstamos sin reglas de negocio avanzadas.
     * </p>
     *
     * @param prestamo préstamo a guardar
     * @return préstamo persistido
     */
    public Prestamo savePrestamo(Prestamo prestamo) {
        return prestamoRepositorio.save(prestamo);
    }
}
