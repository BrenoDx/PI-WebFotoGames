/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.DAO;

import fotogames.persistencia.JPAUtil;
import fotogames.entidades.Orcamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;


/**
 *
 * @author breno
 */
/**
 * Classe responsável por manipular orçamentos no bd.
 */
public class OrcamentoDAO {

    private static EntityManager em; //Instância EntityManager

    /**
     * Método para cadastrar orçamento
     */
    public void cadastrar(Orcamento orcamento) {
        try {
            em = JPAUtil.getEntityManager();

            em.getTransaction().begin();
            em.persist(orcamento);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao cadastrar Orcamento");
        } finally {
            JPAUtil.closeEntity();
        }
    }

    /**
     * Método para retornar os orçamentos.
     */
    public List<Orcamento> listar(){
        try{
            em = JPAUtil.getEntityManager();
            
            Query consulta = em.createQuery("SELECT o FROM Orcamento o");
            List<Orcamento> lista = consulta.getResultList();
            return lista;
        }catch(Exception e){
            throw new RuntimeException("Erro ao listar orcamento");
        }finally{
            JPAUtil.closeEntity();
        }
    }
    
    /**
     * Método para retornar um orçamento.
     */
      public Orcamento getOrcamento(int id) {
        try {
            em = JPAUtil.getEntityManager();
            Orcamento orcamento = null;

           orcamento = em.find(Orcamento.class, id);
            return orcamento;
        } catch(Exception e){
            throw new RuntimeException("Erro ao listar orcamento");
        }finally {
            JPAUtil.closeEntity();
        }
    }
}