package com.appweb.publications.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Book.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Book_ extends com.appweb.publications.model.Publication_ {

	public static final String PAGES = "pages";
	public static final String AUTHOR = "author";
	public static final String ID = "id";
	public static final String TITLE = "title";

	
	/**
	 * @see com.appweb.publications.model.Book#pages
	 **/
	public static volatile SingularAttribute<Book, Integer> pages;
	
	/**
	 * @see com.appweb.publications.model.Book#author
	 **/
	public static volatile SingularAttribute<Book, Author> author;
	
	/**
	 * @see com.appweb.publications.model.Book#id
	 **/
	public static volatile SingularAttribute<Book, String> id;
	
	/**
	 * @see com.appweb.publications.model.Book#title
	 **/
	public static volatile SingularAttribute<Book, String> title;
	
	/**
	 * @see com.appweb.publications.model.Book
	 **/
	public static volatile EntityType<Book> class_;

}

