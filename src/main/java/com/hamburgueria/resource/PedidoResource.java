package com.hamburgueria.resource;

import java.time.LocalDate;

import com.hamburgueria.domain.Pedido;
import com.hamburgueria.enumeration.StatusEnum;
import com.hamburgueria.repository.PedidoRepository;
import com.hamburgueria.repository.ProdutoRepository;

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

@Path( "/pedido" )
public class PedidoResource {
    @Inject
    Jsonb jsonb = JsonbBuilder.create();

    @Inject
    PedidoRepository pedidoRepository;

    @Inject
    ProdutoRepository produtoRepository;

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public String listPedidoByStatusOrData( @QueryParam( "status" ) StatusEnum status, @QueryParam( "data" ) LocalDate data ) {
        return jsonb.toJson( pedidoRepository.getPedidoByStatusOrData( status, data ) );
    }

    @POST
    @Consumes( MediaType.APPLICATION_JSON )
    public Response savePedido( String json ) {
        try {
            pedidoRepository.savePedido( jsonb.fromJson( json, Pedido.class ) );
            return Response.ok().build();
        } catch ( Exception e ) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path( "/status" )
    public String getStatusPedido( @QueryParam( "id" ) Long id ) {
        return jsonb.toJson( pedidoRepository.getStatusPedido( pedidoRepository.findById(id) ) );
    }

    @GET
    @Path( "/notDelivered" )
    public String getPedidosToBeDelivered() {
        return jsonb.toJson( pedidoRepository.getPedidosToBeDelivered() );
    }

    @GET
    @Path( "/report" )
    public String getPedidosByDate( @QueryParam( "data" ) LocalDate data ) {
        return jsonb.toJson( pedidoRepository.getPedidosByDate(data) );
    }

    @GET
    @Path( "/teste" )
    public void teste() {
        produtoRepository.initializeProducts();
    }

}
