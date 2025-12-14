package com.joseluu.biblio_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Entidad que representa un socio de la biblioteca.
 *
 * <p>
 * Mapea la tabla correspondiente en la base de datos mediante JPA.
 * Contiene información básica del socio y sus préstamos.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V1</b> – Entidad mínima para CRUD básico de socios.</li>
 *   <li><b>V3</b> – Preparada para gestionar préstamos y penalizaciones.</li>
 *   <li><b>V4</b> – Usada en el CRUD completo de socios (MVC y REST).</li>
 *   <li><b>V6</b> – Posible integración de Bean Validation (ej. @NotBlank, @Email).</li>
 * </ul>
 *
 * <p>
 * Relación con {@link Prestamo}: un socio puede tener muchos préstamos.
 * Se ignora la lista de préstamos en JSON para evitar ciclos de serialización.
 * </p>
 */
@Entity
public class Socio {

    /** Identificador único del socio. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre completo del socio. No puede ser nulo. */
    @Column(nullable = false)
    private String nombre;

    /** Email del socio. No puede ser nulo y debe ser único. */
    @Column(nullable = false, unique = true)
    private String email;

    /** Fecha de fin de penalización si el socio tiene restricciones de préstamo. */
    @Column(name = "fechaFinPenalizacion")
    private LocalDate fechaFinPenalizacion;

    /**
     * Lista de préstamos asociados al socio.
     *
     * <p>
     * Relación OneToMany con {@link Prestamo}, borrado en cascada y eliminando
     * órfanos. Se ignora en JSON para evitar ciclos.
     * </p>
     */
    @JsonIgnore
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prestamo> prestamos;

    // =======================
    // ======= GETTERS =======
    // =======================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFinPenalizacion() {
        return fechaFinPenalizacion;
    }

    public void setFinPenalizacion(LocalDate fechaFinPenalizacion) {
        this.fechaFinPenalizacion = fechaFinPenalizacion;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
}
