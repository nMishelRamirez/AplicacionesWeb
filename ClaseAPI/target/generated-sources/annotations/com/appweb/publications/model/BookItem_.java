package com.appweb.publications.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(BookItem.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class BookItem_ extends com.appweb.publications.model.Book_ {

	public static final String I_SB_N = "ISBN";

	
	/**
	 * @see com.appweb.publications.model.BookItem#ISBN
	 **/
	public static volatile SingularAttribute<BookItem, Integer> ISBN;
	
	/**
	 * @see com.appweb.publications.model.BookItem
	 **/
	public static volatile EntityType<BookItem> class_;

}

