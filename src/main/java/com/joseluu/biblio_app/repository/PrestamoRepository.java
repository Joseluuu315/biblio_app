package com.joseluu.biblio_app.repository;

import com.joseluu.biblio_app.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para la entidad {@link Prestamo}.
 *
 * <p>
 * Proporciona operaciones de persistencia estándar (CRUD) para la gestión
 * de préstamos de la biblioteca mediante Spring Data JPA.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V1</b> – Acceso básico a datos de préstamos mediante JPA.</li>
 *   <li><b>V3</b> – Base para la implementación de reglas de negocio
 *       (préstamos activos, penalizaciones, bloqueos).</li>
 *   <li><b>V5</b> – Uso desde controladores REST para exposición de la API.</li>
 * </ul>
 *
 * <p>
 * Al extender {@link JpaRepository}, se heredan automáticamente métodos como:
 * </p>
 * <ul>
 *   <li>{@code findAll()}</li>
 *   <li>{@code findById(Long id)}</li>
 *   <li>{@code save(Prestamo prestamo)}</li>
 *   <li>{@code deleteById(Long id)}</li>
 * </ul>
 *
 * <p>
 * En versiones posteriores, este repositorio puede ampliarse con métodos
 * personalizados (por ejemplo, préstamos activos por socio, préstamos fuera
 * de plazo, etc.).
 * </p>
 */
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
