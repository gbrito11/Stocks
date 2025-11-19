package com.app.AppCompras.Repository;

import com.app.AppCompras.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    java.util.List<Produto> findByNomeContainingIgnoreCase(String termo);
}