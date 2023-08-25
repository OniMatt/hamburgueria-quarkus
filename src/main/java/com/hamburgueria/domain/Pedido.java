package com.hamburgueria.domain;

import java.time.LocalDate;
import java.util.List;

import com.hamburgueria.enumeration.StatusEnum;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
public class Pedido extends PanacheEntity {
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "produtos_pedido",
    joinColumns = @JoinColumn(name = "id_pedido"),
    inverseJoinColumns = @JoinColumn(name = "id_produto"))
  private List< Produto > produtosPedido;

  @Enumerated( EnumType.STRING )
  private StatusEnum status;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn( name = "cliente", referencedColumnName = "id" )
  private Cliente cliente;

  private LocalDate data;

  public Pedido( List< Produto > produtosPedido, StatusEnum status,
      Cliente cliente ) {
    this.produtosPedido = produtosPedido;
    this.status = status;
    this.cliente = cliente;
  }

  public Pedido() {
  }

  public List< Produto > getProdutosPedido() {
    return produtosPedido;
  }

  public void setProdutosPedido( List< Produto > produtosPedido ) {
    this.produtosPedido = produtosPedido;
  }

  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus( StatusEnum status ) {
    this.status = status;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente( Cliente cliente ) {
    this.cliente = cliente;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData( LocalDate data ) {
    this.data = data;
  }
}
