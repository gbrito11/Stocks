package com.app.AppCompras.Controller;
import com.app.AppCompras.Model.Produto;
import com.app.AppCompras.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired // Isto diz: "Spring, injeta aqui o Repositório que criaste automaticamente"
    private ProdutoRepository repository;

    // 1. Listar todos (Lê da Base de Dados)
    @GetMapping("/meus-produtos")
    public List<Produto> listar() {
        return repository.findAll(); // O método findAll() já vem pronto!
    }

    // 2. Buscar por ID
    @GetMapping("/meus-produtos/{id}")
    public Produto buscarPorId(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    // 3. Adicionar novo (Grava na Base de Dados)
    @PostMapping("/meus-produtos")
    public Produto adicionar(@RequestBody Produto novoProduto) {
        return repository.save(novoProduto); // O save() faz o INSERT no SQL sozinho!
    }
}