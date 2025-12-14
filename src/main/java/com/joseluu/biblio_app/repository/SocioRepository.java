package com.joseluu.biblio_app.repository;

import com.joseluu.biblio_app.entity.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para la entidad {@link Socio}.
 *
 * <p>
 * Proporciona operaciones estándar de persistencia (CRUD) para los socios
 * de la biblioteca mediante Spring Data JPA.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V1</b> – Acceso básico a datos mediante repositorios JPA.</li>
 *   <li><b>V4</b> – Soporte para CRUD completo de socios.</li>
 *   <li><b>V5</b> – Utilización desde controladores REST.</li>
 * </ul>
 *
 * <p>
 * Al extender {@link JpaRepository}, se heredan métodos como:
 * </p>
 * <ul>
 *   <li>{@code findAll()}</li>
 *   <li>{@code findById(Long id)}</li>
 *   <li>{@code save(Socio socio)}</li>
 *   <li>{@code deleteById(Long id)}</li>
 * </ul>
 *
 * No requiere implementación explícita, ya que Spring genera
 * automáticamente la lógica necesaria en tiempo de ejecución.
 */
public interface SocioRepository extends JpaRepository<Socio, Long> {
}
