package com.joseluu.biblio_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Entidad que representa un socio de la biblioteca.
 */
@Entity
@Schema(
        name = "Socio",
        description = "Representa a un socio registrado en la biblioteca"
)
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            example = "1",
            description = "Identificador único del socio",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Column(nullable = false)
    @Schema(
            example = "Juan Pérez",
            description = "Nombre completo del socio"
    )
    private String nombre;

    @Column(nullable = false, unique = true)
    @Schema(
            example = "juan@email.com",
            description = "Correo electrónico del socio"
    )
    private String email;

    @Column(name = "fechaFinPenalizacion")
    @Schema(
            example = "2025-01-31",
            description = "Fecha de fin de penalización del socio (si aplica)",
            nullable = true
    )
    private LocalDate fechaFinPenalizacion;

    @JsonIgnore
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(
            hidden = true
    )
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
