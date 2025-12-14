package com.joseluu.biblio_app.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Entidad que representa un préstamo de libro realizado por un socio.
 *
 * <p>
 * Mapea la relación entre {@link Socio} y {@link Libro} e incluye información
 * sobre fechas y estado del préstamo.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V1</b> – Entidad mínima para CRUD de préstamos.</li>
 *   <li><b>V3</b> – Base para la lógica de negocio de préstamos:
 *       fechas límite, máximos activos y penalizaciones.</li>
 *   <li><b>V5</b> – Uso en API REST para exponer préstamos.</li>
 *   <li><b>V6</b> – Preparada para Bean Validation y manejo de errores.</li>
 * </ul>
 *
 * <p>
 * Contiene un {@link Estado} que indica si el préstamo está ACTIVO, DEVUELTO
 * o RETRASADO.
 * </p>
 */
@Entity
public class Prestamo {

    /** Identificador único del préstamo. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Socio que realiza el préstamo. Relación ManyToOne obligatoria. */
    @ManyToOne
    @JoinColumn(name = "socio_id", nullable = false)
    private Socio socio;

    /** Libro que se presta. Relación ManyToOne obligatoria. */
    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    /** Fecha en la que se realiza el préstamo. Se inicializa automáticamente si es nula. */
    @Column(name = "fecha_prestamo")
    private LocalDate fechaPrestamo;

    /** Fecha límite para la devolución del libro. */
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    /** Estado actual del préstamo: ACTIVO, DEVUELTO o RETRASADO. */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;

    /** Fecha de inicio del préstamo, obligatoria. */
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    /**
     * Inicializa fechas antes de persistir si no se han asignado.
     *
     * <p>
     * V3 – Permite establecer fechas por defecto para la lógica de préstamos.
     * </p>
     */
    @PrePersist
    public void prePersist() {
        if (fechaPrestamo == null) {
            fechaPrestamo = LocalDate.now();
        }
        if (fechaInicio == null) {
            fechaInicio = LocalDate.now();
        }
    }

    /** Estados posibles de un préstamo. */
    public enum Estado {
        ACTIVO, DEVUELTO, RETRASADO
    }

    // =======================
    // ===== GETTERS/SETTERS =
    // =======================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
