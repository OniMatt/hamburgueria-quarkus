package com.hamburgueria.resource;

import com.hamburgueria.domain.Cliente;
import com.hamburgueria.repository.ClienteRepository;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.*;
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
    public String listClienteByCpfOrEmail( @QueryParam( "email" ) String email, @QueryParam( "cpf" ) String cpf ) {
        return jsonb.toJson( clienteRepository.getClienteByCpfOrEmail( cpf, email ) );
    }

    @POST
    @Consumes( MediaType.APPLICATION_JSON )
    public Response saveCliente( String json ) {
        try {
            clienteRepository.saveCliente( jsonb.fromJson( json, Cliente.class ) );
            return Response.ok().build();
        } catch ( Exception e ) {
            Log.info(e.getMessage());
            return Response.serverError().build();
        }
    }

}
