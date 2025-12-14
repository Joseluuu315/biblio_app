package com.joseluu.biblio_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

/**
 * Entidad que representa un libro en la biblioteca.
 *
 * <p>
 * Mapea la tabla "libro" en la base de datos mediante JPA.
 * Contiene información como título, autor, ISBN, categoría y los préstamos asociados.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V1</b> – Entidad mínima para CRUD de libros.</li>
 *   <li><b>V3</b> – Preparada para gestión de préstamos asociados.</li>
 *   <li><b>V4</b> – Base para CRUD completo de libros (MVC y REST).</li>
 *   <li><b>V5</b> – Expuesta en API REST, lista para JSON.</li>
 *   <li><b>V6</b> – Posible integración de Bean Validation (ej. @NotBlank, @Size, @Pattern).</li>
 * </ul>
 *
 * <p>
 * Relación con {@link Prestamo}: un libro puede tener muchos préstamos.
 * Se ignora en JSON para evitar ciclos de serialización.
 * </p>
 */
@Entity
@Table(name = "libro")
public class Libro {

    /** Identificador único del libro. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Título del libro. No puede ser nulo. */
    @Column(nullable = false)
    private String titulo;

    /** Autor del libro. No puede ser nulo. */
    @Column(nullable = false)
    private String autor;

    /** ISBN del libro. Único y obligatorio. */
    @Column(nullable = false, unique = true, length = 13)
    private String isbn;

    /** Categoría del libro. Puede ser nula. */
    private String categoria;

    /**
     * Lista de préstamos asociados al libro.
     *
     * <p>
     * Relación OneToMany con {@link Prestamo}, borrado en cascada y eliminando órfanos.
     * Ignorada en JSON para evitar ciclos.
     * </p>
     */
    @JsonIgnore
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
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
