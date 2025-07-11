package com.appweb.publications.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Usuario.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Usuario_ {

	public static final String CORREO = "correo";
	public static final String ID = "id";
	public static final String NOMBRE = "nombre";

	
	/**
	 * @see com.appweb.publications.model.Usuario#correo
	 **/
	public static volatile SingularAttribute<Usuario, String> correo;
	
	/**
	 * @see com.appweb.publications.model.Usuario#id
	 **/
	public static volatile SingularAttribute<Usuario, Long> id;
	
	/**
	 * @see com.appweb.publications.model.Usuario
	 **/
	public static volatile EntityType<Usuario> class_;
	
	/**
	 * @see com.appweb.publications.model.Usuario#nombre
	 **/
	public static volatile SingularAttribute<Usuario, String> nombre;

}

