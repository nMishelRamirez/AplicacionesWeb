package com.appweb.publications.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.MappedSuperclassType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(Person.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Person_ {

	public static final String DOB = "dob";
	public static final String NAME = "name";
	public static final String ID = "id";

	
	/**
	 * @see com.appweb.publications.model.Person#dob
	 **/
	public static volatile SingularAttribute<Person, LocalDate> dob;
	
	/**
	 * @see com.appweb.publications.model.Person#name
	 **/
	public static volatile SingularAttribute<Person, String> name;
	
	/**
	 * @see com.appweb.publications.model.Person#id
	 **/
	public static volatile SingularAttribute<Person, Long> id;
	
	/**
	 * @see com.appweb.publications.model.Person
	 **/
	public static volatile MappedSuperclassType<Person> class_;

}

