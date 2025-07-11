package com.appweb.publications.resource;

import jakarta.inject.*;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

import com.appweb.publications.model.Usuario;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {


	 @PersistenceContext(unitName = "CRUD_PU")
	    private EntityManager em;

	    // GET - listar todos
	    @GET
	    public List<Usuario> listar() {
	        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
	    }

	    // GET - obtener uno por ID
	    @GET
	    @Path("/{id}")
	    public Response obtener(@PathParam("id") Long id) {
	        Usuario usuario = em.find(Usuario.class, id);
	        if (usuario == null) {
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        return Response.ok(usuario).build();
	    }

	    // POST - crear nuevo
	    @POST
	    @Transactional
	    public Response crear(Usuario usuario, @Context UriInfo uriInfo) {
	        em.persist(usuario);
	        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(usuario.getId().toString());
	        return Response.created(builder.build()).entity(usuario).build();
	    }

	    // PUT - editar
	    @PUT
	    @Path("/{id}")
	    @Transactional
	    public Response editar(@PathParam("id") Long id, Usuario datosActualizados) {
	        Usuario existente = em.find(Usuario.class, id);
	        if (existente == null) {
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }

	        existente.setNombre(datosActualizados.getNombre());
	        existente.setCorreo(datosActualizados.getCorreo());
	        em.merge(existente);
	        return Response.ok(existente).build();
	    }

	    // DELETE - eliminar
	    @DELETE
	    @Path("/{id}")
	    @Transactional
	    public Response eliminar(@PathParam("id") Long id) {
	        Usuario usuario = em.find(Usuario.class, id);
	        if (usuario == null) {
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        em.remove(usuario);
	        return Response.noContent().build();
	    }
	}