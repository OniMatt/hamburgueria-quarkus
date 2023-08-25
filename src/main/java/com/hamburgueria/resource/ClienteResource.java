package com.hamburgueria.resource;

import com.hamburgueria.domain.Cliente;
import com.hamburgueria.repository.ClienteRepository;

import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path( "/cliente" )
public class ClienteResource {
    @Inject
    Jsonb jsonb = JsonbBuilder.create();

    @Inject
    ClienteRepository clienteRepository;

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public String listClienteByEmail( @QueryParam( "email" ) String email ) {
        return jsonb.toJson( clienteRepository.getClienteByEmail( email ) );
    }

    @POST
    @Consumes( MediaType.APPLICATION_JSON )
    public Response createCliente( String json ) {
        try {
            clienteRepository.saveCliente( jsonb.fromJson( json, Cliente.class ) );
            return Response.ok().build();
        } catch ( Exception e ) {
            return Response.serverError().build();
        }
    }
}
