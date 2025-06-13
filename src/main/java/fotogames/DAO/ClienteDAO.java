/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.DAO;

import fotogames.entidades.Cliente;
import fotogames.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author breno
 */
/**
 * Método responsável para manipular clientes no BD.
 */
public class ClienteDAO {

    private static EntityManager em; // Instância EntityManager

    /**
     * Método para cadastrar cliente
     */
    public void cadastrar(Cliente cliente) {
        em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao cadastrar cliente: ");
        } finally {
            JPAUtil.closeEntity();
        }
    }

    /**
     * Método retornar uma lista de clientes cadastrados.
     */
    public List<Cliente> listar() {
        em = JPAUtil.getEntityManager();
        try {
            Query consulta = em.createQuery("SELECT c FROM Cliente c");
            List<Cliente> lista = consulta.getResultList();
            return lista;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar clientes: ");
        } finally {
            JPAUtil.closeEntity();
        }
    }

    /**
     * Método para retorna apenas um cliente
     */
    public Cliente getCliente(int id) {
        em = JPAUtil.getEntityManager();
        try {
            Cliente cliente = null;
            cliente = em.find(Cliente.class, id);
            return cliente;
            
        } catch (Exception e) {
            System.out.println("Erro ao buscar cliente: ");
        } finally {
            JPAUtil.closeEntity();
        }
        return null;
    }
}
