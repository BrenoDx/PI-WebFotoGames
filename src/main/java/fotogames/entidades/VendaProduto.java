/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.entidades;

import fotogames.entidades.Produto;
import fotogames.entidades.Venda;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author breno
 */

/**
 * Classe que representa Venda_Produto
 */
@Entity
@Table(name = "venda_produto")
public class VendaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único.

    private int quantidade;
    private double valorTotal; // Valor total da venda

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda; // Chave estrangeira venda

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto; // Chave estrageira produto

    /**
     * Obtém Identificador único. 
     */
    public int getId() {
        return id;
    }

    /**
     * Define o Identificador único. 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o valor.
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * Define o valor.
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Obtém a chave estrangeira venda.
     */
    public Venda getVenda() {
        return venda;
    }

    /**
     * Define a chave estrangeira venda.
     */
    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    /**
     * Obtém a chave estrangeira produto.
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Define a chave estrangeira produto.
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * Obtém quantidade. 
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade. 
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    
    
}
