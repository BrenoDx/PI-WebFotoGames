/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.DAO;

import fotogames.persistencia.JPAUtil;
import fotogames.entidades.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author breno
 */
/**
 * Método responsável por manipular o estoque no BD.
 */
public class ProdutoDAO {

    private static EntityManager em; // Instância EntityManager.

    /**
     * Método para cadastrar produto
     */
    public void cadastrar(Produto produto) {
        try {
            em = JPAUtil.getEntityManager();

            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao cadastrar produto");
        } finally {
            JPAUtil.closeEntity();
        }
    }

    /**
     * Método retornar uma lista de produtos cadastrado.
     */
    public List<Produto> listar() {
        try {
            em = JPAUtil.getEntityManager();

            Query consulta = em.createQuery("SELECT p FROM Produto p");
            List<Produto> lista = consulta.getResultList();
            return lista;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar produtos" + e.getMessage());
        } finally {
            JPAUtil.closeEntity();
        }
    }

    /**
     * Método para retornar apenas um produto.
     */
    public List<Produto> getProduto(Produto produto) {
        try {
            em = JPAUtil.getEntityManager();

            Query consulta = em.createQuery("SELECT p FROM Produto p WHERE nomeProduto = :produto");
            consulta.setParameter("produto", produto);

            List<Produto> produtoEncontrado = consulta.getResultList();
            return produtoEncontrado;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar o produto");
        }
    }

    /**
     * Método para retornar um produto pela ID. 
     */
    public Produto getProdutoID(int id) {
        try {
            em = JPAUtil.getEntityManager();
            
           // em.getTransaction().begin();
            Produto produto = em.find(Produto.class, id);
           // em.getTransaction().commit();
            
            return produto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar produto");
        } finally {
            JPAUtil.closeEntity();
        }
    }

    /**
     * Método para alterar dados do produto. 
     */
    public void editarProduto(int id, String nomeProduto, String fabricante, String categoria, String plataforma, String cor, int garantia, double valor) {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            
            Query query = em.createQuery("UPDATE Produto p SET p.nomeProduto = :nomeProduto, p.fabricante = :fabricante, p.categoria = :categoria, p.plataforma = :plataforma, p.cor = :cor, p.garantia = :garantia, p.valor = :valor WHERE p.id = :id");
            query.setParameter("nomeProduto", nomeProduto);
            query.setParameter("fabricante", fabricante);
            query.setParameter("categoria", categoria);
            query.setParameter("plataforma", plataforma);
            query.setParameter("cor", cor);
            query.setParameter("garantia", garantia);
            query.setParameter("valor", valor);
            query.setParameter("id", id);

            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao alterar produto");
        }finally{
            JPAUtil.closeEntity();
        }
    }
}
