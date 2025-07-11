package com.appweb.publications.model;

import jakarta.persistence.*;

/**
 * Representa una publicación multimedia, como un video o audio.
 * <p>
 * Esta clase extiende de Publication y agrega propiedades como el formato
 * y el título de la multimedia.
 * </p>
 */
@Entity
@Table(name = "multimedia")
@Inheritance(strategy = InheritanceType.JOINED)
public class Multimedia extends Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String format;

    @Override
    public void publish() {
        System.out.println("Publishing multimedia: " + title);
    }

    // Getters y Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getFormat() { return format; }

    public void setFormat(String format) { this.format = format; }
}
