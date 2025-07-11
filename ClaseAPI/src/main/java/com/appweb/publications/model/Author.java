package com.appweb.publications.model;

import jakarta.persistence.*;

/**
 * Representa un autor que tiene un nombre asociado.
 * <p>
 * Esta clase extiende de la clase Person y agrega un campo adicional
 * para el nombre del autor.
 * </p>
 */
@Entity
@Table(name = "author")
public class Author extends Person {

    @Column(name = "author_name", nullable = false)
    private String authorName;

    // Getters y Setters
    /**
     * Obtiene el nombre del autor.
     * @return El nombre del autor.
     */
    public String getAuthorName() { return authorName; }

    /**
     * Establece el nombre del autor.
     * @param authorName El nombre del autor.
     */
    public void setAuthorName(String authorName) { this.authorName = authorName; }
}
