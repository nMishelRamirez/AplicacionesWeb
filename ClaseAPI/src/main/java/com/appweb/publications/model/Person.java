package com.appweb.publications.model;

import java.time.LocalDate;
import jakarta.persistence.*;

/**
 * Representa una persona, la cual tiene un nombre, fecha de nacimiento e ID.
 * <p>
 * Esta clase es la clase base para Author y otras entidades relacionadas con personas.
 * </p>
 */
@MappedSuperclass
public abstract class Person {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate dob;

    // Getters y Setters
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public LocalDate getDob() { return dob; }

    public void setDob(LocalDate dob) { this.dob = dob; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
}
