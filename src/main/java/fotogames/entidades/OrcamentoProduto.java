/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.entidades;

import fotogames.entidades.Orcamento;
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
 * Classe que representa Orcamento_Produto.
 */
@Entity
@Table(name = "orcamento_produto")
public class OrcamentoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único.
    
   
    private double valorTotal; // Valor Total.
    
    @ManyToOne
    @JoinColumn(name= "orcamento_id")
    private Orcamento orcamento; // Chave estrangeira Orcamento.
    
    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto; // Chave estrangeira Produto.

    /**
     * Obtém o valor total.
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * Define o valor total.
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Obtém a chave estrangeira orcamento.
     */
    public Orcamento getOrcamento() {
        return orcamento;
    }

    /**
     * Define a chave estrangeira orcamento.
     */
    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    /**
     * Obtém a chave estrangeira produto.
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * define a chave estrangeira produto.
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
}
