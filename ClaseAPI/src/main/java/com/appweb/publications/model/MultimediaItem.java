package com.appweb.publications.model;

import jakarta.persistence.*;
/**
 * Representa un ítem multimedia con un ID único.
 * <p>
 * Esta clase extiende de Multimedia y agrega un campo para almacenar el ID del ítem multimedia.
 * </p>
 */
@Entity
@Table(name = "multimediaitem")
public class MultimediaItem extends Multimedia {

    private int itemId;

    // Getters y Setters
    public int getItemId() { return itemId; }

    public void setItemId(int itemId) { this.itemId = itemId; }
}
