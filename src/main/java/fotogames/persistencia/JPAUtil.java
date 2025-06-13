/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author breno
 */

/**
 * Classe que representa as conexões com banco de dados
 */
public class JPAUtil {

    private static final String PERSISTENCE_UNIT = "fgdb";// Nome da unidade de persistência definida no arquivo persistence.xml
    private static EntityManager em;  // Instância do EntityManager
    private static EntityManagerFactory emf; // Instância do Factory

    /**
     * Método de criação e retorno para interação com banco de dados
     */
    public static EntityManager getEntityManager() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
        return em;
    }

    /**
     * Método para fechar EntityManager e o Factory
     */
    public static void closeEntity() {
        if (em.isOpen() && em != null) {
            em.close();
            emf.close();
        }
    }
}