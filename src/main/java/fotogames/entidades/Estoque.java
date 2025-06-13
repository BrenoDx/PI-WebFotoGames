/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;





/**
 *
 * @author breno
 */
/**
 * Classe que representa o estoque da loja
 */
@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Identificador único do produto

    private int quantidade; // quantidade no estoque

    @OneToOne
    @JoinColumn(name="produto_id", unique = true)
    private Produto produto; // Chave estrangeira Produto

    /**
     * Obtém o identificador único.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém a quantidade no estoque.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade no estoque.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Obtém chave estrangeira Produto.
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Define chave estrangeira Produto.
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
