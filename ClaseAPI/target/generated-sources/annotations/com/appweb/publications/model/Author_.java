package com.appweb.publications.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Author.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Author_ extends com.appweb.publications.model.Person_ {

	public static final String AUTHOR_NAME = "authorName";

	
	/**
	 * @see com.appweb.publications.model.Author#authorName
	 **/
	public static volatile SingularAttribute<Author, String> authorName;
	
	/**
	 * @see com.appweb.publications.model.Author
	 **/
	public static volatile EntityType<Author> class_;

}

