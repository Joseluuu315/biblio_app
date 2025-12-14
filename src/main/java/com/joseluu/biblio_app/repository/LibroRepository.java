package com.joseluu.biblio_app.repository;

import com.joseluu.biblio_app.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para la entidad {@link Libro}.
 *
 * <p>
 * Proporciona operaciones estándar de persistencia (CRUD) para los libros
 * de la biblioteca mediante Spring Data JPA.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V1</b> – Acceso básico a datos de libros mediante JPA.</li>
 *   <li><b>V4</b> – Soporte para CRUD completo de libros.</li>
 *   <li><b>V5</b> – Utilización desde controladores REST.</li>
 * </ul>
 *
 * <p>
 * Al extender {@link JpaRepository}, se heredan automáticamente métodos como:
 * </p>
 * <ul>
 *   <li>{@code findAll()}</li>
 *   <li>{@code findById(Long id)}</li>
 *   <li>{@code save(Libro libro)}</li>
 *   <li>{@code deleteById(Long id)}</li>
 * </ul>
 *
 * <p>
 * En versiones posteriores, este repositorio puede ampliarse con métodos
 * personalizados (por ejemplo, búsqueda por título, estado o disponibilidad).
 * </p>
 */
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
