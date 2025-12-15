package com.joseluu.biblio_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;

/**
 * Entidad que representa un libro en la biblioteca.
 */
@Entity
@Table(name = "libro")
@Schema(
        name = "Libro",
        description = "Representa un libro disponible en la biblioteca"
)
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            example = "5",
            description = "Identificador único del libro",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Column(nullable = false)
    @Schema(
            example = "El Señor de los Anillos",
            description = "Título del libro"
    )
    private String titulo;

    @Column(nullable = false)
    @Schema(
            example = "J. R. R. Tolkien",
            description = "Autor del libro"
    )
    private String autor;

    @Column(nullable = false, unique = true, length = 13)
    @Schema(
            example = "9780544003415",
            description = "ISBN del libro (13 caracteres)"
    )
    private String isbn;

    @Schema(
            example = "Fantasía",
            description = "Categoría del libro"
    )
    private String categoria;

    @JsonIgnore
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(hidden = true)
    private List<Prestamo> prestamos;

    // =======================
    // ===== GETTERS/SETTERS =
    // =======================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
}
