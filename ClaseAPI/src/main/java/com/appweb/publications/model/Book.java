package com.appweb.publications.model;

import jakarta.persistence.*;

/**
 * Representa un libro publicado.
 * <p>
 * Un libro tiene un título, número de páginas, y un autor asociado.
 * </p>
 */
@Entity
@Table(name = "book")
@Inheritance(strategy = InheritanceType.JOINED)
public class Book extends Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int pages;

    @ManyToOne(optional = false) // Un libro debe tener un autor
    private Author author;

    @Override
    public void publish() {
        System.out.println("Publishing book: " + title);
    }

    // Getters y Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public int getPages() { return pages; }

    public void setPages(int pages) { this.pages = pages; }

    public Author getAuthor() { return author; }

    public void setAuthor(Author author) { this.author = author; }
}
