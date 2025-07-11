package com.appweb.publications.model;

import jakarta.persistence.*;

/**
 * Representa una publicación abstracta.
 * <p>
 * Esta clase es la clase base para otros tipos de publicaciones como libros o multimedia.
 * </p>
 */
@MappedSuperclass
public abstract class Publication {

    /**
     * Método abstracto que define el comportamiento de la publicación.
     * Las subclases deben proporcionar una implementación de este método.
     */
    public abstract void publish();
}
