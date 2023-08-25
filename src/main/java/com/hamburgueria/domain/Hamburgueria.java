package com.hamburgueria.domain;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class Hamburgueria extends PanacheEntity {
  private String nome;

  @Transient
  private List< Produto > cardapio;

  @Transient
  private List< Cliente > clientes;

  public Long getId() {
    return id;
  }

  public void setId( Long id ) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome( String nome ) {
    this.nome = nome;
  }

  public List< Cliente > getClientes() {
    return clientes;
  }

  public void setClientes( List< Cliente > clientes ) {
    this.clientes = clientes;
  }

  public List< Produto > getCardapio() {
    return cardapio;
  }

  public void setCardapio( List< Produto > cardapio ) {
    this.cardapio = cardapio;
  }

}
