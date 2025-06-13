/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 *
 * @author breno
 */
@Entity
@DiscriminatorValue("Jogo")
public class Jogo extends Produto{
    private String Plataforma;

    public Jogo() {
    }

    public String getPlataforma() {
        return Plataforma;
    }

    public void setPlataforma(String Plataforma) {
        this.Plataforma = Plataforma;
    }   

    @Override
    public String toString() {
        return super.toString() + ", Plataforma: " + Plataforma;
    }
    
    
}
