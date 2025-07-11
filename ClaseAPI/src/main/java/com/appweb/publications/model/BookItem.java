package com.appweb.publications.model;

import jakarta.persistence.*;

/**
 * Representa un ítem de libro con un ISBN único.
 * <p>
 * Esta clase extiende de Book y agrega un campo para almacenar el ISBN.
 * </p>
 */
@Entity
@Table(name = "bookitem")
public class BookItem extends Book {

    private int ISBN;

    // Getters y Setters
    public int getISBN() { return ISBN; }

    public void setISBN(int ISBN) { this.ISBN = ISBN; }
}
