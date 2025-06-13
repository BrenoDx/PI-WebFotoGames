/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.DAO;

import fotogames.entidades.Acesso;
import fotogames.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author breno
 */

/**
 * Classe resposável para validar os acessos dos funcionarios
 */
public class SegurancaDAO {

    private EntityManager em; // Instância do EntityManager

    /**
     * Método do tipo Funcionario para efetuar o acesso
     */
    public Acesso validarAcesso(String login, String passworld) {
        Acesso funcionario = new Acesso();
        try {
            em = JPAUtil.getEntityManager();
            Query consulta = em.createQuery("SELECT a FROM Acesso a WHERE a.email = :email AND a.senha = :passworld");
            consulta.setParameter("email", login);
            consulta.setParameter("passworld", passworld);

            funcionario = (Acesso) consulta.getSingleResult();
            return funcionario;
        } catch (NoResultException e) {
            throw new RuntimeException("Erro acesso");
        } finally {
            JPAUtil.closeEntity();
       }
    }

    /**
     * Método pra definir a senha MD5.
     */
    public String getMD5(String passworld) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] by = md.digest(passworld.getBytes());
            BigInteger bi = new BigInteger(1, by);
            String hashText = bi.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}