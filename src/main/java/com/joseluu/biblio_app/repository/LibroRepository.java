package com.joseluu.biblio_app.repository;

import com.joseluu.biblio_app.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
