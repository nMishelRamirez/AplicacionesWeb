package com.appweb.publications.resource;

import jakarta.inject.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;
import com.appweb.publications.model.BookItem;

/**
 * Endpoints para manejar operaciones sobre las copias de libros.
 */
@Path("/book-items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookItemResource {

    @PersistenceContext(unitName = "CRUD_PU")
    private EntityManager em;

    /**
     * Obtiene la lista de todas las copias de libros.
     * 
     * @return Lista de copias de libros.
     */
    @GET
    public List<BookItem> getAll() {
        return em.createQuery("SELECT bi FROM BookItem bi", BookItem.class).getResultList();
    }

    /**
     * Crea una nueva copia de un libro.
     * 
     * @param bookItem La nueva copia del libro a crear.
     * @param uriInfo Información de la URI para generar la URL de la nueva copia.
     * @return Respuesta con la nueva copia de libro y su URI.
     */
    @POST
    @Transactional
    public Response create(BookItem bookItem, @Context UriInfo uriInfo) {
        em.persist(bookItem);  // Persistir entidad
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(String.valueOf(bookItem.getISBN()));
        return Response.created(builder.build()).entity(bookItem).build();
    }
}
