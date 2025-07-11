package com.appweb.publications.resource;

import jakarta.inject.*;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;
import com.appweb.publications.model.Book;

/**
 * Endpoints para manejar operaciones sobre los libros.
 */
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @PersistenceContext(unitName = "CRUD_PU")
    private EntityManager em;

    /**
     * Obtiene la lista de todos los libros.
     * 
     * @return Lista de libros.
     */
    @GET
    public List<Book> getAll() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    /**
     * Crea un nuevo libro.
     * 
     * @param book El libro a crear.
     * @param uriInfo Información de la URI para generar la URL del nuevo libro.
     * @return Respuesta con el libro creado y su URI.
     */
    @POST
    @Transactional
    public Response create(Book book, @Context UriInfo uriInfo) {
        em.persist(book);  // Persistir entidad
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(book.getId().toString());
        return Response.created(builder.build()).entity(book).build();
    }

    /**
     * Actualiza un libro existente.
     * 
     * @param id El ID del libro a actualizar.
     * @param updatedBook El libro con los nuevos datos.
     * @return Respuesta con el libro actualizado.
     */
    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Book updatedBook) {
        Book book = em.find(Book.class, id);
        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        book.setTitle(updatedBook.getTitle());
        book.setPages(updatedBook.getPages());
        book.setAuthor(updatedBook.getAuthor());
        em.merge(book);  // Actualizar entidad
        return Response.ok(book).build();
    }

    /**
     * Elimina un libro.
     * 
     * @param id El ID del libro a eliminar.
     * @return Respuesta con el estado de la operación.
     */
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Book book = em.find(Book.class, id);
        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        em.remove(book);  // Eliminar entidad
        return Response.noContent().build();
    }

    /**
     * Publica un libro.
     * 
     * @param id El ID del libro a publicar.
     * @return Respuesta con el mensaje de publicación.
     */
    @POST
    @Path("/{id}/publish")
    @Transactional
    public Response publish(@PathParam("id") Long id) {
        Book book = em.find(Book.class, id);
        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        System.out.println("Book published: " + book.getTitle());
        return Response.ok("Book published: " + book.getTitle()).build();
    }
}
