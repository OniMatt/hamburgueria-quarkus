package com.hamburgueria.repository;

import java.util.ArrayList;
import java.util.List;

import com.hamburgueria.domain.Produto;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository< Produto > {

    @Transactional
    public void initializeProducts() {
        List< Produto > produtos = new ArrayList<>();
        produtos.add( new Produto( "Hambúrguer de Risoto de Camarão", 35.0 ) ); 
        produtos.add( new Produto( "Hambúrguer de Macarrão à Bolonhesa", 20.0 ) );
        produtos.add( new Produto( "Hambúrguer de Fettuccine ao Molho Alfredo", 30.0 ) );
        produtos.add( new Produto( "Hambúrguer de Filé Mignon ao Molho Madeira", 25.0 ) );
        produtos.add( new Produto( "Hambúrguer de Gnocchi de Ricota", 25.0 ) );
        produtos.add( new Produto( "Del Valle de Morango", 5.0 ) ); 
        produtos.add( new Produto( "Dolly Limão", 8.0 ) );
        produtos.add( new Produto( "Charrua Safra 1980 Envelhecido", 19.0 ) );
        produtos.add( new Produto( "Chá Matte Leão", 5.0 ) );
        produtos.add( new Produto( "Ceva", 5.0 ) );

        produtos.forEach( produto -> {
            this.persist(produto);
        });
    }    
}
