package com.appweb.publications.resource;

import jakarta.inject.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;
import com.appweb.publications.model.Multimedia;

/**
 * Endpoints para manejar operaciones sobre el contenido multimedia.
 */
@Path("/multimedia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MultimediaResource {

    @PersistenceContext(unitName = "CRUD_PU")
    private EntityManager em;

    /**
     * Obtiene la lista de todos los contenidos multimedia.
     * 
     * @return Lista de contenidos multimedia.
     */
    @GET
    public List<Multimedia> getAll() {
        return em.createQuery("SELECT m FROM Multimedia m", Multimedia.class).getResultList();
    }

    /**
     * Crea un nuevo contenido multimedia.
     * 
     * @param multimedia El multimedia a crear.
     * @param uriInfo Información de la URI para generar la URL del nuevo contenido.
     * @return Respuesta con el nuevo multimedia y su URI.
     */
    @POST
    @Transactional
    public Response create(Multimedia multimedia, @Context UriInfo uriInfo) {
        em.persist(multimedia);  // Persistir entidad
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(multimedia.getId().toString());
        return Response.created(builder.build()).entity(multimedia).build();
    }

    /**
     * Actualiza un contenido multimedia existente.
     * 
     * @param id El ID del contenido multimedia a actualizar.
     * @param updatedMultimedia El multimedia con los nuevos datos.
     * @return Respuesta con el multimedia actualizado.
     */
    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Multimedia updatedMultimedia) {
        Multimedia multimedia = em.find(Multimedia.class, id);
        if (multimedia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        multimedia.setTitle(updatedMultimedia.getTitle());
        multimedia.setFormat(updatedMultimedia.getFormat());
        em.merge(multimedia);  // Actualizar entidad
        return Response.ok(multimedia).build();
    }

    /**
     * Elimina un contenido multimedia.
     * 
     * @param id El ID del contenido multimedia a eliminar.
     * @return Respuesta con el estado de la operación.
     */
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Multimedia multimedia = em.find(Multimedia.class, id);
        if (multimedia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        em.remove(multimedia);  // Eliminar entidad
        return Response.noContent().build();
    }
}
