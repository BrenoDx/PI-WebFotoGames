/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.DAO;

import fotogames.persistencia.JPAUtil;
import fotogames.entidades.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author breno
 */

/**
 * Classe responsável pra manipular venda no BD.
 */
public class VendaDAO {

    private static EntityManager em; //Instância EntityManager

    /**
     * Método para cadastrar a venda
     */
    public void cadastrar(Venda venda){
        try{
            em = JPAUtil.getEntityManager();
            
            em.getTransaction().begin();
            em.persist(venda);
            em.getTransaction().commit();
            
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao cadastrar venda");
        }finally{
            JPAUtil.closeEntity();
        }
    }
    
    /**
     * Método para retornar as vendas
     */
    public List<Venda> listar(){
        try{
            em = JPAUtil.getEntityManager();
            
            Query consulta = em.createQuery("SELECT v FROM Venda v");
            List<Venda> lista = consulta.getResultList();
            
            return lista;
        } catch(Exception e){
            throw new RuntimeException("Erro ao listar venda");
        }finally{
            JPAUtil.closeEntity();
        }
    }
}
