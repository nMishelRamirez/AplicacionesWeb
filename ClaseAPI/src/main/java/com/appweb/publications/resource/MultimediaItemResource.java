package com.appweb.publications.resource;

import jakarta.inject.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;
import com.appweb.publications.model.MultimediaItem;

/**
 * Endpoints para manejar operaciones sobre las copias de multimedia.
 */
@Path("/multimedia-items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MultimediaItemResource {

    @PersistenceContext(unitName = "CRUD_PU")
    private EntityManager em;

    /**
     * Obtiene la lista de todas las copias de multimedia.
     * 
     * @return Lista de copias de multimedia.
     */
    @GET
    public List<MultimediaItem> getAll() {
        return em.createQuery("SELECT mi FROM MultimediaItem mi", MultimediaItem.class).getResultList();
    }

    /**
     * Crea una nueva copia de multimedia.
     * 
     * @param multimediaItem La nueva copia de multimedia a crear.
     * @param uriInfo Información de la URI para generar la URL de la nueva copia.
     * @return Respuesta con la nueva copia de multimedia y su URI.
     */
    @POST
    @Transactional
    public Response create(MultimediaItem multimediaItem, @Context UriInfo uriInfo) {
        em.persist(multimediaItem);  // Persistir entidad
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(String.valueOf(multimediaItem.getItemId()));
        return Response.created(builder.build()).entity(multimediaItem).build();
    }
}
