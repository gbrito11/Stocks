package com.app.AppCompras.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantidade;

    private String nome;
    private double preco;

    @jakarta.persistence.ManyToOne // Muitos produtos para Uma categoria
    @jakarta.persistence.JoinColumn(name = "categoria_id") // Cria a coluna na tabela
    private Categoria categoria;

    // 1. CONSTRUTOR VAZIO (Essencial!)
    public Produto() {
    }

    // 2. CONSTRUTOR COM DADOS (Para usares no código se precisares)
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}