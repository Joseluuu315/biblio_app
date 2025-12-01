package com.joseluu.biblio_app.repository;

import com.joseluu.biblio_app.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
