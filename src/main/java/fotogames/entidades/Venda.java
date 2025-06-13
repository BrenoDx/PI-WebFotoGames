/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author breno
 */

/**
 * Classe que representa venda
 */
@Entity
public class Venda {
    
    private Date data; // Data da venda
    private String formPagamento; // Forma de pagamento
    
    @Id
    @Column(name="nf")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nf; // Nota Fiscal e como identificador único
    
    @ManyToOne
    @JoinColumn(name="orcamento_id")
    private Orcamento orcamento; // Chave estrangeira orcamento
    
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente; // Chave estrageira cliente

    @OneToMany(mappedBy="venda")
    private List<VendaProduto> venda = new ArrayList<>(); // Chave mapeada na classe Venda_Produto

    /**
     * Obtém a data da venda.
     */
    public Date getData() {
        return data;
    }

    /**
     * Define a data da venda.
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Obtém a forma de pagamento.
     */
    public String getFormPagamento() {
        return formPagamento;
    }

    /**
     * Define a forma de pagamento.
     */
    public void setFormPagamento(String formPagamento) {
        this.formPagamento = formPagamento;
    }

    /**
     * Obtém a nota fiscal.
     */
    public int getNf() {
        return nf;
    }

    /**
     * Define a nota fiscal.
     */
    public void setNf(int nf) {
        this.nf = nf;
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
     * Obtém a chave estrangeira cliente.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define a chave estrangeira cliente.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtém lista venda_produto.
     */
    public List<VendaProduto> getProduto() {
        return venda;
    }

    /**
     * Define lista Venda_Produto.
     */
    public void setProduto(List<VendaProduto> venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "---Cliente: " + cliente.getNome() + ", Pagamento: " + formPagamento + ", NF: " + nf +
                ", Data: " + data;
    }
    
    
}
