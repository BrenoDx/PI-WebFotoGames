/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.DAO;

import fotogames.persistencia.JPAUtil;
import fotogames.entidades.OrcamentoProduto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author breno
 */
/**
 * Classe responsável por manipular Orcamentos_Produtos no bd.
 */
public class OrcamentoProdutoDAO {

    private static EntityManager em; //Instância EntityManager

    /**
     * Método para cadastrar
     */
    public void cadastrar(OrcamentoProduto op) {
        em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(op);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao cadastrar Orcamento");
        } finally {
            JPAUtil.closeEntity();
        }
    }

    /**
     * Método para listar.
     */
    public List<OrcamentoProduto> listar() {
        em = JPAUtil.getEntityManager();
        List<OrcamentoProduto> lista;
        try {
            Query consulta = em.createQuery("SELECT op FROM Orcamento_Produto op WHERE op.orcamento.id IN ("
                    + "SELECT DISTINCT op2.orcamento.id FROM Orcamento_Produto op2"
                    + ")",
                    OrcamentoProduto.class
            );
            lista = consulta.getResultList();
            return lista;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar orcamento");
        } finally {
            JPAUtil.closeEntity();
        }
    }

    /**
     * Método para retornar um Orcamento_Produto.
     */
    public OrcamentoProduto getOP(int id) {
        try {
            em = JPAUtil.getEntityManager();

            Query consulta = em.createQuery("SELECT op FROM Orcamento_Produto op JOIN op.orcamento o WHERE o.id = :id ");
            consulta.setParameter("id", id);

            List<OrcamentoProduto> lista = consulta.getResultList();
            if (!lista.isEmpty()) {
                return lista.get(0);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar orcamento");
        } finally {
            JPAUtil.closeEntity();
        }
        return null;
    }
}
