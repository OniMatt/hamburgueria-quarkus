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
      this.getEntityManager().merge( cliente );
    }, () -> {
      this.getEntityManager().merge( cliente );
    } );
  }

  public List< Cliente > listAllClientes() {
    return this.listAll();
  }

  public Cliente getClienteById( Long id ) {
    return this.findById( id );
  }

  public List< Cliente > getClienteByCpfOrEmail( String cpf, String email ) {
    if( cpf != null && email == null ) {
      return this.list( "SELECT c FROM Cliente c WHERE cpf like '" + cpf + "'");
    }

    if( cpf == null && email != null ) {
      return this.list( "SELECT c FROM Cliente c WHERE email like '" + email + "'");
    }

    if( cpf != null && email != null ) {
      return this.list( "SELECT c FROM Cliente c WHERE email like '" + email + "' AND cpf like '" + cpf + "'");
    }
    return this.listAll();
  }

  @Transactional
  public void deleteCliente( Cliente cliente ) {
    this.delete( cliente );
  }

}
