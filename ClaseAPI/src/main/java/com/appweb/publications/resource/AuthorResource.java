package com.appweb.publications.resource;

import jakarta.inject.*;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

import com.appweb.publications.model.Author;


/**
 * Endpoints para manejar operaciones sobre los autores.
 */
@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

    @PersistenceContext(unitName = "CRUD_PU")
    private EntityManager em;

    /**
     * Obtiene la lista de todos los autores.
     * 
     * @return Lista de autores
     */
    @GET
    public List<Author> getAll() {
        return em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }
    
 // GET - obtener uno por ID
    @GET
    @Path("/{id}")
    public Response obtener(@PathParam("id") Long id) {
    	Author usuario = em.find(Author.class, id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(usuario).build();
    }

    /**
     * Crea un nuevo autor en la base de datos.
     * 
     * @param author El autor a crear.
     * @param uriInfo Información de la URI para generar la URL del nuevo autor.
     * @return Respuesta con el nuevo autor y su URI.
     */
    @POST
    @Transactional
    public Response create(Author author, @Context UriInfo uriInfo) {
        em.persist(author);  // Persistir entidad
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(author.getId().toString());
        return Response.created(builder.build()).entity(author).build();
    }

    /**
     * Actualiza los datos de un autor existente.
     * 
     * @param id El ID del autor a actualizar.
     * @param updatedAuthor Los nuevos datos del autor.
     * @return Respuesta con el autor actualizado.
     */
    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Author updatedAuthor) {
        Author author = em.find(Author.class, id);
        if (author == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        // Actualizar campos
        author.setAuthorName(updatedAuthor.getAuthorName());
        author.setName(updatedAuthor.getName());
        author.setDob(updatedAuthor.getDob());
        em.merge(author);  // Actualizar entidad
        return Response.ok(author).build();
    }

    /**
     * Elimina un autor de la base de datos.
     * 
     * @param id El ID del autor a eliminar.
     * @return Respuesta que indica el estado de la operación.
     */
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Author author = em.find(Author.class, id);
        if (author == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        em.remove(author);  // Eliminar entidad
        return Response.noContent().build();
    }
}
