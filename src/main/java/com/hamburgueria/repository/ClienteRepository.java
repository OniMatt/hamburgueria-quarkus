package com.hamburgueria.repository;

import java.util.List;
import java.util.Optional;

import com.hamburgueria.domain.Cliente;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository< Cliente > {

  @Transactional
  public void saveCliente( Cliente cliente ) {
    Optional< Cliente > clienteOptional = this.findByIdOptional( cliente.id );

    clienteOptional.ifPresentOrElse( clienteTemp -> {
      cliente.setNome( cliente.getNome() );
      cliente.setEmail( cliente.getEmail() );
      cliente.setSenha( cliente.getSenha() );
      cliente.setTelefone( cliente.getTelefone() );
      this.persistAndFlush( cliente );
    }, () -> {
      this.getEntityManager().merge( cliente );
    } );
  }

  public List< Cliente > listAllClientes() {
    return this.listAll();
  }

  public List< Cliente > getClienteById( Long id ) {
    return this.list( "id like", id );
  }

  public List< Cliente > getClienteByEmail( String email ) {
    return this.list( "SELECT c FROM Cliente c WHERE email like '" + email + "'");
  }

  @Transactional
  public void deleteCliente( Cliente cliente ) {
    this.delete( cliente );
  }

}
