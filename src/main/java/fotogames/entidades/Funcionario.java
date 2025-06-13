/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author breno
 */

/**
 * Classe que representa um Funcionario no sistema, contendo informações básicas
 */
@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Identificador único do usuarios
    
    private String nome, cargo; // Informações básicas (Nome e o cargo)

     /**
     * Obtém o identificador único.
     */
    public int getId() {
        return id;
    }

     /**
     *  Define o identificador único.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtém o nome.
     */
    public String getNome() {
        return nome;
    }

     /**
     * Define o nome.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

     /**
     * Obtém o cargo.
     */
    public String getCargo() {
        return cargo;
    }

     /**
     * Define o cargo.
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}