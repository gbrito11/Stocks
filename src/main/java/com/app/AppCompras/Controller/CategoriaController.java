package com.app.AppCompras.Controller;

import com.app.AppCompras.Model.Categoria;
import com.app.AppCompras.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public List<Categoria> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Categoria adicionar(@RequestBody Categoria categoria) {
        return repository.save(categoria);
    }
}