/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.entidades;

import fotogames.entidades.Cliente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author breno
 */

@Entity
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id; //Identificador único do usuarios
    
    private LocalDate data; //Data do Orçamento
    
    @OneToMany(mappedBy="orcamento")
    private List<OrcamentoProduto> lista = new ArrayList<>(); // Chave mapeada na classe Orcamento_Produto.
    
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente; // Chave estrangeira Cliente.

    /**
     * Obtém o Identificador único.
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
     * Obtém lista Orcamento_Produto.
     */
    public List<OrcamentoProduto> getLista() {
        return lista;
    }

    /**
     * Define lista Orcamento_Produto.
     */
    public void setLista(List<OrcamentoProduto> lista) {
        this.lista = lista;
    }

    /**
     * Obtém a chave estrangeira Cliente.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define a chave estrangeira Cliente.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtém data do orçamento.
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Define data do orçamento.
     */
    public void setData(LocalDate data) {
        this.data = data;
    }
}
