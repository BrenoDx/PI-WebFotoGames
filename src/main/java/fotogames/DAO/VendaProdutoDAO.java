/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.DAO;

import fotogames.persistencia.JPAUtil;
import fotogames.entidades.VendaProduto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author breno
 */

/**
 * Classe responsável por manipular Venda_Produto no bd.
 */
public class VendaProdutoDAO {
    private static EntityManager em; //Instância EntityManager
    
    /**
     * Método para cadastrar.
     */
    public void cadastrar(VendaProduto vendaproduto){
        try{
            em = JPAUtil.getEntityManager();
            
            em.getTransaction().begin();
            em.persist(vendaproduto);
            em.getTransaction().commit();
            
        }catch(Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao cadastrar venda");
        }finally{
            JPAUtil.closeEntity();
        }
    }
    
    /**
     * Método para listar. 
     */
    public List<VendaProduto> listar(){
        try{
            em = JPAUtil.getEntityManager();
            
            Query consulta = em.createQuery("SELECT vp FROM Venda_Produto vp");
            List<VendaProduto> lista = consulta.getResultList();
            return lista;
        }catch(Exception e){
            throw new RuntimeException("Erro ao listar venda");
        }finally{
            JPAUtil.closeEntity();
        }
    }
}
