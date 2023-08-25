package com.hamburgueria.domain;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Produto extends PanacheEntity {
  private String nome;
  private double preco;

  @ManyToMany(mappedBy = "produtosPedido")
  private List< Pedido > pedidos;

  public Produto( Long id, String nome, double preco ) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
  }

  public Produto() {
  }

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

  public double getPreco() {
    return preco;
  }

  public void setPreco( double preco ) {
    this.preco = preco;
  }
}
