package com.app.AppCompras.Controller;

import com.app.AppCompras.Model.Categoria;
import com.app.AppCompras.Model.Produto;
import com.app.AppCompras.Repository.CategoriaRepository;
import com.app.AppCompras.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // ============================================================
    // GESTÃO DE PRODUTOS
    // ============================================================

    @GetMapping("/loja")
    public String listarProdutos(Model model, @RequestParam(required = false) String keyword) {

        java.util.List<Produto> lista;


        if (keyword != null && !keyword.isEmpty()) {
            lista = produtoRepository.findByNomeContainingIgnoreCase(keyword);
        } else {
            lista = produtoRepository.findAll();
        }

        double valorTotalStock = 0.0;
        for (Produto p : lista) {

            valorTotalStock += (p.getPreco() * p.getQuantidade());
        }


        model.addAttribute("listaProdutos", lista);
        model.addAttribute("valorTotalStock", valorTotalStock); // Enviamos o total aqui!

        return "tabela";
    }
    @GetMapping("/loja/novo")
    public String mostrarFormularioNovo(Model model) {
        model.addAttribute("produto", new Produto());
        // AQUI ESTÁ A LIMPEZA: Só enviamos categorias, nada de produtores
        model.addAttribute("listaCategorias", categoriaRepository.findAll());
        return "formulario";
    }

    @GetMapping("/loja/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        model.addAttribute("produto", produto);
        model.addAttribute("listaCategorias", categoriaRepository.findAll());
        return "formulario";
    }

    @PostMapping("/loja/salvar")
    public String salvarProduto(Produto produto, @RequestParam(required = false) String novaCategoriaNome) {

        // Lógica para criar categoria nova na hora (se o user escreveu algo)
        if (novaCategoriaNome != null && !novaCategoriaNome.isEmpty()) {
            Categoria novaCat = new Categoria(novaCategoriaNome);
            categoriaRepository.save(novaCat);
            produto.setCategoria(novaCat);
        }

        produtoRepository.save(produto);
        return "redirect:/loja";
    }

    @GetMapping("/loja/eliminar/{id}")
    public String eliminarProduto(@PathVariable Integer id) {
        produtoRepository.deleteById(id);
        return "redirect:/loja";
    }



    // ============================================================
    // GESTÃO DE CATEGORIAS
    // ============================================================

    @GetMapping("/loja/categorias")
    public String listarCategorias(Model model) {
        model.addAttribute("listaCategorias", categoriaRepository.findAll());
        return "tabela-categorias";
    }

    @GetMapping("/loja/categoria/nova")
    public String novaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "form-categoria";
    }

    @GetMapping("/loja/categoria/editar/{id}")
    public String editarCategoria(@PathVariable Integer id, Model model) {
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        model.addAttribute("categoria", categoria);
        return "form-categoria";
    }

    @PostMapping("/loja/categoria/salvar")
    public String salvarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
        return "redirect:/loja/categorias";
    }

    @GetMapping("/loja/categoria/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Integer id) {
        categoriaRepository.deleteById(id);
        return "redirect:/loja/categorias";
    }
}