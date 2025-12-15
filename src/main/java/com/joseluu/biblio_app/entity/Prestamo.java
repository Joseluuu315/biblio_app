package com.joseluu.biblio_app.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Entidad que representa un préstamo de libro realizado por un socio.
 */
@Entity
@Schema(
        name = "Prestamo",
        description = "Representa el préstamo de un libro realizado por un socio"
)
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            example = "10",
            description = "Identificador único del préstamo",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "socio_id", nullable = false)
    @Schema(
            description = "Socio que realiza el préstamo"
    )
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    @Schema(
            description = "Libro que se presta"
    )
    private Libro libro;

    @Column(name = "fecha_prestamo")
    @Schema(
            example = "2025-01-10",
            description = "Fecha en la que se realiza el préstamo"
    )
    private LocalDate fechaPrestamo;

    @Column(name = "fecha_fin")
    @Schema(
            example = "2025-01-25",
            description = "Fecha límite para la devolución del libro"
    )
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Schema(
            description = "Estado actual del préstamo",
            example = "ACTIVO",
            allowableValues = {"ACTIVO", "DEVUELTO", "RETRASADO"}
    )
    private Estado estado;

    @Column(name = "fecha_inicio", nullable = false)
    @Schema(
            example = "2025-01-10",
            description = "Fecha de inicio del préstamo"
    )
    private LocalDate fechaInicio;

    @PrePersist
    public void prePersist() {
        if (fechaPrestamo == null) {
            fechaPrestamo = LocalDate.now();
        }
        if (fechaInicio == null) {
            fechaInicio = LocalDate.now();
        }
    }

    /**
     * Estados posibles de un préstamo.
     */
    @Schema(
            description = "Estados posibles de un préstamo"
    )
    public enum Estado {
        ACTIVO,
        DEVUELTO,
        RETRASADO
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
