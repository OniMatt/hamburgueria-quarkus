package com.hamburgueria.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hamburgueria.domain.Pedido;
import com.hamburgueria.enumeration.StatusEnum;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido> {

  @Transactional
  public void savePedido(Pedido pedido) {
    Optional<Pedido> pedidoOptional = this.findByIdOptional(pedido.id);

    pedidoOptional.ifPresentOrElse(pedidoTemp -> {
      pedido.setProdutosPedido(pedido.getProdutosPedido());
      pedido.setStatus(pedido.getStatus());
      pedido.setCliente(pedido.getCliente());
      pedido.setData(pedido.getData());
      this.getEntityManager().merge(pedido);
    }, () -> {
      this.getEntityManager().merge(pedido);
    });
  }

  public List<Pedido> getPedidoByStatusOrData(StatusEnum status, LocalDate data) {
    String query = "SELECT p FROM Pedido p WHERE 1 = 1";

    if (status != null) {
      query += " AND p.status = :status";
    }

    if (data != null) {
      query += " AND p.data = :data";
    }

    TypedQuery<Pedido> typedQuery = getEntityManager().createQuery(query, Pedido.class);

    if (status != null) {
      typedQuery.setParameter("status", status);
    }

    if (data != null) {
      typedQuery.setParameter("data", data);
    }

    return typedQuery.getResultList();
  }

  public StatusEnum getStatusPedido( Pedido pedido ) {
    return findById( pedido.id ).getStatus();
  }

  public List< Pedido > getPedidosToBeDelivered() {
    return this.list( "SELECT p FROM Pedido p WHERE p.status NOT IN ('ENTREGUE', 'CANCELADO')");
  }

  public List< Pedido > getPedidosByDate( LocalDate data ) {
    String query = "SELECT p FROM Pedido p WHERE p.data = :data";
    TypedQuery<Pedido> typedQuery = getEntityManager().createQuery(query, Pedido.class);

    if (data != null) {
      typedQuery.setParameter("data", data);
    }

    return typedQuery.getResultList();
  }

  @Transactional
  public void deletePedido(Pedido pedido) {
    this.delete(pedido);
  }
}
